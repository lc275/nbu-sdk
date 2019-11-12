package com.github.lc.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageAttributesExt extends ImageAttributes {
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private String backupId;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Integer masterId;

    /**
     * 将数据库读出的行结构转为java对象
     * @return
     */
    public Image toImage(){
        Image image = new Image();
        image.setAttributes(this);
        image.setId(this.getBackupId());
        return image;
    }
    /**
     * 超过复制时间窗口	为空	备份大小比较	结果
     * TRUE	            TRUE		            fail
     * TRUE	            FALSE	    >	        fail
     * TRUE	            FALSE	    =	        success
     * FALSE	        TRUE		            waiting
     * FALSE	        FALSE	    >	        running
     * FALSE	        FALSE	    =	        success
     */
    public void determinAirStatus(ImageAttributesExt another, JobDetailsAttributes jd) {
        //超出时间窗口并且（没有复制或者复制大小不够）
        if (outOfAIRWindow() && (another == null || this.getKbytes() > another.getKbytes())) {
            jd.setAirStatus(AIRStatus.FAIL);
            return;
        }
        if (another != null && getKbytes().equals(another.getKbytes())) {
            jd.setAirStatus(AIRStatus.SUCCESS);
            return;
        }
        if(!outOfAIRWindow()&&another==null){
            jd.setAirStatus(AIRStatus.WAITING);
            return;
        }
        jd.setAirStatus(AIRStatus.RUNNING);
    }

    /**
     * 是否超出air复制时间窗口
     * @return
     */
    private boolean outOfAIRWindow(){
        long oneDay=24*60*60*1000;
        long now = System.currentTimeMillis();
        return this.getBackupTime().getTime()+oneDay<now;
    }
}
