package com.github.lc.schema.host;

import lombok.Data;

@Data
public class MappingDetails {
    private String  mappedHostName;
    private String isApproved;
    private String isConflicting;
    private String isAddedManually;
    private String  origin;
    private String  isShared;
    private long  createdOn;
    private long  updatedOn;
}
