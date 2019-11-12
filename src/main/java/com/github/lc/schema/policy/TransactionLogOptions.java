package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class TransactionLogOptions {
    private String backupBlockSize;
    private int backupStripes;
    private int clientBuffersPerStripe;
    private boolean convertLogBackupsToFull;
    private String maxTransferSize;
    private int parallelBackupOps;
    private boolean skipUnavailableDatabases;
    private String sqlServerChecksum;
    private boolean truncateLogsAfterBackup;
    private boolean useSQLServerCompression;
}