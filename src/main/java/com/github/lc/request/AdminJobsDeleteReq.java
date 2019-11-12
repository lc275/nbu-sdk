package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class AdminJobsDeleteReq extends AbstractReq{

    public AdminJobsDeleteReq(Object jobId){
        this.put("jobId",jobId);
    }

    @Override
    protected String uri() {
        return UriPath.DELETE_ADMIN_JOBS;
    }
}
