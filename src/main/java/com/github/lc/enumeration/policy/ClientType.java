package com.github.lc.enumeration.policy;

public enum ClientType {
    INSTANCES("Protect Instances and Databases"),
    INSTANCEGROUPS("Protect Instance Groups"),
    CLIENTS("Clients");

    private String value;
    ClientType(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
