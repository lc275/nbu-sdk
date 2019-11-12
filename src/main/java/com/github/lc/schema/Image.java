package com.github.lc.schema;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Image {
    private static String CATALOG_BACKUP_POLICY_NAME="catalogbackup";
    private String id;
    private ImageAttributes attributes;

    /**
     * 是否catalog备份
     * @return
     */
    public boolean catalogBackUp(){
        return attributes.getPolicyName().equalsIgnoreCase(CATALOG_BACKUP_POLICY_NAME);
    }
}
