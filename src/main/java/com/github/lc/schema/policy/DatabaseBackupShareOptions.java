package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class DatabaseBackupShareOptions {
    private boolean deleteBackupCopies;
    private boolean deleteBackupSets;
    private int deleteProtectedBackupCopiesMinutes;
    private int deleteProtectedBackupSetsMinutes;
}
