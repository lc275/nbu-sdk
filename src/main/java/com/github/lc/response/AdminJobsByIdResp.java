package com.github.lc.response;

import com.github.lc.schema.JobDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminJobsByIdResp {
    private JobDetails data;
}
