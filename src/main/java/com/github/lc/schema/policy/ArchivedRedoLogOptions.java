package com.github.lc.schema.policy;

import lombok.Data;

@Data
public class ArchivedRedoLogOptions {
    private int backupSetSize;
    private int deleteAfterMakingCopies;
    private int filesPerBackupSet;
    private boolean include;
    private int parallelStreams;
}
