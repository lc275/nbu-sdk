package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class PolicyAttributes {
    private boolean active;
    private String autoManagedLabel;
    private int autoManagedType;
    private String dataClassification;
    private String effectiveDateUTC;
    private int jobLimit;
    private String keyword;
    private String mediaOwner;
    private int priority;
    private String storage;
    private boolean storageIsSLP;
    private String volumePool;
}
