package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class PolicySQLServer extends PolicyAttributes{
       private String alternateClientHostname;
       private String backupSelectionType;
       private boolean clientCompress;
       private boolean clientEncrypt;
       private String clientType;
       private String dataMoverMachine;
       private DatabaseOptions databaseOptions;
       private boolean disableClientSideDeduplication;
       private boolean offhostBackup;
       private boolean retainSnapshot;
       private boolean snapshotBackup;
       private String snapshotMethod;
       private String snapshotMethodArgs;
       private TransactionLogOptions transactionLogOptions;
}
