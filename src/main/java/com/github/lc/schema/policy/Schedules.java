package com.github.lc.schema.policy;

import lombok.Data;

import java.util.List;

@Data
public class Schedules {
    private boolean acceleratorForcedRescan;
    private BackupCopies backupCopies;
    private String backupType;
    private ExcludeDates excludeDates;
    private int frequencySeconds;
    private IncludeDates includeDates;
    private int mediaMultiplexing;
    private boolean retriesAllowedAfterRunDay;
    private String scheduleName;
    private String scheduleType;
    private boolean snapshotOnly;
    private List<StartWindow> startWindow;
    private boolean storageIsSLP;
    private boolean syntheticBackup;

    @Data
    public static class BackupCopies{
        private List<Copies> copies;
        private int priority;
    }

    @Data
    public static class Copies{
        private String failStrategy;
        private String mediaOwner;
        private RetentionPeriod retentionPeriod;
        private String storage;
        private String volumePool;
    }
    @Data
    public static class RetentionPeriod{
        private String unit;
        private int value;
    }
    @Data
    public static class ExcludeDates{
        private boolean lastDayOfMonth;
        private List<Integer> recurringDaysOfMonth;
        private List<String> recurringDaysOfWeek;
        private List<String> specificDates;
    }
    @Data
    public static class IncludeDates{
        private boolean lastDayOfMonth;
        private List<Integer> recurringDaysOfMonth;
        private List<String> recurringDaysOfWeek;
        private List<String> specificDates;
    }
    @Data
    public static class StartWindow{
        private int dayOfWeek;
        private int durationSeconds;
        private int startSeconds;
    }
}
