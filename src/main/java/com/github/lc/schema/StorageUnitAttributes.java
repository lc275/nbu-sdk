package com.github.lc.schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorageUnitAttributes {
    private String storageUnitName;
    private String storageServerState;
    private String diskPoolState;
    private String storageServerName;
    private String storageType;
    private String storageServerType;
    private Long freeCapacityBytes;
    private Long usedCapacityBytes;
    private Long totalCapacityBytes;
    private Boolean replicationTargetCapable;
    private Boolean replicationSourceCapable;
    private Boolean replicationCapable;
}
