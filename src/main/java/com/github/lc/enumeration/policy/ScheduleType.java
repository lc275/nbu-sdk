package com.github.lc.enumeration.policy;

public enum ScheduleType {
    Calendar("Calendar"),
    Frequency("Frequency");
    private String value;
    ScheduleType(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
