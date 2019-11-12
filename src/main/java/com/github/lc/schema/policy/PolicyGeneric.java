package com.github.lc.schema.policy;

import lombok.Data;

import java.util.List;

@Data
public class PolicyGeneric extends PolicyAttributes {
       private String alternateClientHostname;
       private boolean applicationConsistent;
       private boolean applicationDiscovery;
       private List<String> applicationProtection;
       private ArchivedRedoLogOptions archivedRedoLogOptions;
       private BackupFileNameFormatOverrides backupFileNameFormatOverrides;
       private String backupHost;
       private String backupSelectionType;
       private String backupSetIdentifier;
       private boolean blockIncremental;
       private int checkpointIntervalMinutes;
       private boolean clientCompress;
       private boolean clientEncrypt;
       private String clientType;
       private boolean collectBareMetalRestoreInfo;
       private String collectTrueImageRestoreInfo;
       private boolean crossMountPoints;
       private String dataMoverMachine;
       private DatabaseBackupShareOptions databaseBackupShareOptions;
       private DatabaseOptions databaseOptions;
       private String datafileCopyTag;
       private boolean disableClientSideDeduplication;
       private int discoveryLifetime;
       private String exchangeDatabaseBackupSource;
       private List<String> exchangeServerList;
       private boolean followNFSMounts;
       private boolean granularRecovery;
       private String hypervServer;
       private MaximumLimits maximumLimits;
       private boolean offhostBackup;
       private boolean offlineDatabaseBackup;
       private boolean optimizedBackup;
       private int parallelStreams;
       private String readOnlyTablespaceOptions;
       private boolean retainSnapshot;
       private String secondarySnapshotMethodArgs;
       private boolean skipOfflineDatafiles;
       private boolean snapshotBackup;
       private String snapshotMethod;
       private String snapshotMethodArgs;
       private TransactionLogOptions transactionLogOptions;
       private boolean useAccelerator;
       private boolean useMultipleDataStreams;
       private boolean useReplicationDirector;
       private int useVirtualMachine;

}
