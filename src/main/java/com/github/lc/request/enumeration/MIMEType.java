package com.github.lc.request.enumeration;

public enum MIMEType {
    JSON("application/vnd.netbackup+json;version=2.0"),
    TEXT("text/vnd.netbackup+plain;version=2.0");

    private String value;
    MIMEType(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
