package com.github.lc.schema.policy;

import lombok.Data;

import java.util.List;

@Data
public class Policy {
    private String policyName;
    private String policyType;
    private PolicyAttributes policyAttributes;
    private BackupSelections backupSelections;
    private List<Clients> clients;
    private List<Schedules> schedules;
}
