package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class PolicyOracle extends PolicyAttributes {
      private String alternateClientHostname;
      private ArchivedRedoLogOptions archivedRedoLogOptions;
      private BackupFileNameFormatOverrides backupFileNameFormatOverrides;
      private String backupSelectionType;
      private String backupSetIdentifier;
      private boolean blockIncremental;
      private boolean clientCompress;
      private boolean clientEncrypt;
      private String clientType;
      private String dataMoverMachine;
      private DatabaseBackupShareOptions databaseBackupShareOptions;
      private String datafileCopyTag;
      private boolean disableClientSideDeduplication;
      private boolean followNFSMounts;
      private MaximumLimits maximumLimits;
      private boolean offhostBackup;
      private boolean offlineDatabaseBackup;
      private int parallelStreams;
      private String readOnlyTablespaceOptions;
      private boolean retainSnapshot;
      private boolean skipOfflineDatafiles;
      private boolean snapshotBackup;
      private String snapshotMethod;
      private String snapshotMethodArgs;
      private boolean useAccelerator;
      private boolean useReplicationDirector;

}
