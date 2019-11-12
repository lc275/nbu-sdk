package com.github.lc.request;


import com.github.lc.request.path.UriPath;

public class AdminJobsRestartPostReq extends AbstractReq {

    public AdminJobsRestartPostReq(Object jobId){
        this.put("jobId",jobId);
    }
    @Override
    protected String uri() {
        return UriPath.POST_ADMIN_JOBS_RESTART;
    }
}
