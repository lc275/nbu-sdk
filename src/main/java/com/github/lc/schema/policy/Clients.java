package com.github.lc.schema.policy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Clients {
    @JsonProperty("OS")
    private String OS;

    @JsonProperty("OS")
    public String getOS() {
        return OS;
    }

    @JsonProperty("OS")
    public void setOS(String OS) {
        this.OS = OS;
    }

    private String databaseName;
    private String hardware;
    private String hostName;
    private String instanceGroup;
    private String instanceName;
}
