package com.github.lc.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.lc.util.JsonDateSerializer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ImageAttributes {
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Integer jobId;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Integer kbytes;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Integer kbytesDataTransferred;
    private String policyName;
    private String policyType;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private String slpName;
    private String clientName;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date backupTime;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date expiration;
    private String scheduleType;


}
