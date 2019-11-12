package com.github.lc.schema.host;

import lombok.Data;

import java.util.List;

@Data
public class Host {
    private String  uuid;
    private String  hostName;
    private String  masterServer;
    private String  osType;
    private String  osVersion;
    private String  installedEEBs;
    private String  hwDescription;
    private String  cpuArchitecture;
    private String  nbuVersion;
    private String  isSecureEnabled;
    private String  autoReissue;
    private int autoReissueDuration;
    private String   comment;
    private long  createdDateTime;
    private long  lastUpdatedDateTime;
    private List<String> servers;
    private List<MappingDetails> hostMappings;
}
