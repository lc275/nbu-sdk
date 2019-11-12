package com.github.lc.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StorageUnitsReplicaRelaResp {
    private StorageUnitsReplicaRelaData data;

    @Getter
    @Setter
    public static class StorageUnitsReplicaRelaData {
        private String type;
        private String id;
        private RelationAttributes attributes;
    }

    @Getter
    @Setter
    public static class RelationAttributes {
        private String targetMasterServerName;
        private String dataClassificationName;
        private String targetMasterImportSlpName;
    }
}
