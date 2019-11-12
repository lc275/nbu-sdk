package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class DatabaseOptions {
    private String backupBlockSize;
    private int backupStripes;
    private int clientBuffersPerStripe;
    private boolean convertDiffBackupsToFull;
    private boolean copyOnlyBackup;
    private String maxTransferSize;
    private int parallelBackupOps;
    private boolean skipReadOnlyFilegroups;
    private boolean skipUnavailableDatabases;
    private String sqlServerChecksum;
    private boolean useSQLServerCompression;
}
