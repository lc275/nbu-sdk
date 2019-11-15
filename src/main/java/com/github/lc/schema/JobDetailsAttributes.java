package com.github.lc.schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.lc.util.HierarchyObject;
import com.github.lc.util.JsonDateSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Slf4j
@ToString
public class JobDetailsAttributes implements HierarchyObject<JobDetailsAttributes> {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long parentJobId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String backupId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String policyType;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String scheduleType;

    private String groupName;
    //该属性映射job_exec表字段master_id
    private Integer masterId;
    private Long jobId;
    private Integer id;
    private String jobType;
    private String scheduleName;
    private String policyName;
    private String clientName;
    private Double dedupRatio;
    private Long kilobytesTransferred;
    private Long accKilobytesTransferred;
    private String state;
    private Integer status;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date startTime;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date endTime;
    private boolean isMysqlRestore;
    private String mysqlRestoreLog;
    @JsonIgnore
    private List<JobDetailsAttributes> children;
    /*恢复任务的文件列表*/
    private String fileList;

    private boolean cutoverFlag;

    @Override
    public boolean ifRoot() {
        //       BACKUP、RESTORE      || IMAGEDELETE、REPLICA_IMPORT等
        return jobId.equals(parentJobId) || parentJobId == 0;
    }

    @Override
    public boolean ifParentOf(JobDetailsAttributes other) {
        return this.getJobId().equals(other.getParentJobId()) && !other.ifRoot();
    }

    /**
     * 递归获取备份的数据量
     *
     * @return
     */
    public long kilobytesTransferred() {
        long sum = getKilobytesTransferred();
        if (!CollectionUtils.isEmpty(children)) {
            for (JobDetailsAttributes child : children) {
                sum += child.kilobytesTransferred();
            }
        }
        return sum;
    }

    public long accKilobytesTransferred() {
        //单节点任务 = 根节点&& 没有子节点
        boolean singleNodeJob = ifRoot() && CollectionUtils.isEmpty(children);
        //单节点任务 && 删重率为空
        if (singleNodeJob && dedupRatio == null) {
            return kilobytesTransferred;
        }
        if (dedupRatio != null) {
            accKilobytesTransferred = new Double(kilobytesTransferred * (1 - dedupRatio / 100)).longValue();
        }
        Long sum = accKilobytesTransferred == null ? 0 : accKilobytesTransferred;
        if (!CollectionUtils.isEmpty(children)) {
            for (JobDetailsAttributes child : children) {
                sum += child.accKilobytesTransferred();
            }
        }
        return sum;
    }

    /**
     * 获取子任务中第一个非零的状态码赋值给父任务
     *
     * @return
     */
    public Integer status() {
        Integer sum = getStatus();
        if (!CollectionUtils.isEmpty(children)) {
            for (JobDetailsAttributes child : children) {
                if (child.getStatus() != 0) {
                    sum = child.getStatus();
                    break;
                }
            }
        }
        return sum;
    }

    public void policyType() {
        /*oracle类型的备份任务会拆分为子任务，父任务的clientName为nbu master的名称
        因此需要设置为子任务的clientName;*/
        if ("ORACLE".equals(policyType) && !CollectionUtils.isEmpty(children)) {
            this.setClientName(children.get(0).getClientName());
        }
    }

    /**
     * 刷新属性,该方法是对其他方法的组合:
     * 1 status()
     * 2 kilobytesTransferred()
     * 3 policyType()
     */
    public void refreshField() {
        log.debug("当前父任务的信息为{}", this);
        /*如果是失败状态则保持原有的状态码，
          如果是成功状态,则检查子任务状态是否有失败，并将子任务的失败状态赋值给父任务*/
        if (parentJobId == 0) {//IMAGEDELETE、REPLICA_IMPORT 类型的任务不做刷新直接返回
            return;
        }
        if (status == null) {//state=null的时候status会为空
            setStatus(0);
        } else {
            setStatus(status != 0 ? status : status());
        }
        setKilobytesTransferred(kilobytesTransferred());
        setAccKilobytesTransferred(accKilobytesTransferred());
        policyType();
    }
}
