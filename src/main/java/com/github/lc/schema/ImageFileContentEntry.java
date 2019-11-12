package com.github.lc.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.lc.util.JsonDateSerializer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ImageFileContentEntry {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long blockNumber;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long compressedFileSize;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer deviceNumber;
    private String filePath;
    private Long fileSize;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String group;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer inImageFlag;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String inodeLastModified;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date lastAccessTime;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date lastModifiedTime;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer pathMode;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer rawPartitionSize;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String user;
}
