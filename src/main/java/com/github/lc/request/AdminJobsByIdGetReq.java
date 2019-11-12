package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class AdminJobsByIdGetReq extends AbstractReq {

    public AdminJobsByIdGetReq(Integer jobId) {
        this.put("jobId", jobId);
    }

    @Override
    protected String uri() {
        return UriPath.GET_ADMIN_JOBS_BY_ID;
    }
}
