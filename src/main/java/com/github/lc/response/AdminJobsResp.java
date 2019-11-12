package com.github.lc.response;

import com.github.lc.schema.JobDetails;
import com.github.lc.schema.Meta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AdminJobsResp implements ListableResp<JobDetails> {
    private List<JobDetails> data;
    private Meta meta;
}
