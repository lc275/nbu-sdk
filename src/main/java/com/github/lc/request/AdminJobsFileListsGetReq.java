package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class AdminJobsFileListsGetReq extends AbstractReq {


    public AdminJobsFileListsGetReq(Object jobId){
        this.put("jobId",jobId);
    }

    @Override
    protected String uri() {
        return UriPath.GET_ADMIN_JOBS_FILE_LISTS;
    }
}
