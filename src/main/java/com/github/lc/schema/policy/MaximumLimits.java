package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class MaximumLimits {
    private int backupPiece;
    private int backupSetSize;
    private int filesPerBackupSet;
    private int openFiles;
    private int readRate;
}
