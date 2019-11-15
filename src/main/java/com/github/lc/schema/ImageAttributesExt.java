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

}
