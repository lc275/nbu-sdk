package com.github.lc.enumeration.policy;

public enum BackupSelectionType {
    WHOLEDATABASE("Whole Database"),
    DATAFILECOPYSHARE("Whole Database - Datafile Copy Share"),
    TABLESPACE("Partial Database - Tablespace"),
    DATAFILES("Partial Database - Datafiles"),
    FRA("Fast Recovery Area (FRA)"),
    CLIENTS("Clients"),
    BACKUPSHARES("Database Backup Shares");

    private String value;
    BackupSelectionType(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}