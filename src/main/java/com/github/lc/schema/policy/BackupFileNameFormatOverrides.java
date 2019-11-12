package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class BackupFileNameFormatOverrides {
    private String archivedRedoLogs;
    private String controlFile;
    private String datafiles;
    private String fastRecoveryArea;
}
