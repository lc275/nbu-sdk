package com.github.lc.request;

import static com.github.lc.request.path.UriPath.POST_ADMIN_JOBS_CANCLE;

public class AdminJobsCancelPostReq extends AbstractReq {

    public AdminJobsCancelPostReq(Long jobId){
        put("jobId",jobId);
    }

    @Override
    protected String uri() {
        return POST_ADMIN_JOBS_CANCLE;
    }
}
