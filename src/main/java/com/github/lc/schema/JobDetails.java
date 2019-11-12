package com.github.lc.schema;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobDetails {
    private JobDetailsAttributes attributes;
    private String id;
    private String type;
}
