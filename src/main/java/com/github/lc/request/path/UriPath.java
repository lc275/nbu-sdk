package com.github.lc.request.path;

/**
 * 常量类，配置请求路径
 * 路径命名规则：请求方法+路径
 */
public class UriPath {
    /*登录地址*/
    public static final String POST_NETBACKUP_LOGIN = "/login";
    /*ping master连接*/
    public static final String GET_PING = "/ping";

    public static final String GET_ADMIN_JOBS = "/admin/jobs";

    public static final String GET_ADMIN_JOBS_BY_ID = "/admin/jobs/{jobId}";

    public static final String GET_ADMIN_JOBS_FILE_LISTS="/admin/jobs/{jobId}/file-lists";
    /*删除失败任务*/
    public static final String DELETE_ADMIN_JOBS = "/admin/jobs/{jobId}";
    /*任务重新发起接口*/
    public static final String POST_ADMIN_JOBS_RESTART = "/admin/jobs/{jobId}/restart";

    public static final String POST_ADMIN_JOBS_CANCLE ="/admin/jobs/{jobId}/cancel";

    public static final String GET_CATALOG_IMAGES = "/catalog/images";

    public static final String DELETE_CATALOG_IMAGES_CONTENT = "/catalog/images/contents/{requestId}";
    //创建策略接口
    public static final String POST_CONFIG_POLICY = "/config/policies/";
    //修改策略接口
    public static final String PUT_CONFIG_POLICY = "/config/policies/{policyName}";
    //删除策略接口
    public static final String DELETE_CONFIG_POLICY = "/config/policies/{policyName}";
    //获取策略列表接口
    public static final String GET_CONFIG_POLICIES = "/config/policies/";
    //获取策略信息接口
    public static final String GET_CONFIG_POLICY = "/config/policies/{policyName}";
    //获取Host信息接口
    public static final String GET_CONFIG_HOSTS = "/config/hosts/hostmappings";
    //根据requestId 获取备份的详细信息
    public static final String GET_CATALOG_IMAGES_CONTENTS = "/catalog/images/contents/{requestId}";
    /*根据backupId获取requestId*/
    public static final String GET_CATALOG_IMAGES_REQUESTID = "/catalog/images/{backupId}/contents";

    public static final String GET_STORAGE_UNITS = "/storage/storage-units";

    public static final String GET_STORAGE_UNITS_REPLICATION_RELATIONSHIP = "/storage/storage-units/{storageUnitName}/replication-relationships";

    public static final String GET_CONFIG_SLPS = "/config/slps";

    public static final String  PUT_POLICY_SCHEDULE="/config/policies/{policyName}/schedules/{scheduleName}";

    private UriPath() {
    }
}
