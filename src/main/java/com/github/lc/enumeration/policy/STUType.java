package com.github.lc.enumeration.policy;

/**
 * storage unit type
 */
public enum STUType {
    BASIC_DISK("BasicDisk"),
    PURE_DISK("PureDisk"),
    ADVANCED_DISK("AdvancedDisk"),
    SLP("slp");
    private String name;

    STUType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
