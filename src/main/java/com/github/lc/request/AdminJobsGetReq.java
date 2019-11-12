package com.github.lc.request;

import com.github.lc.request.path.UriPath;
import com.github.lc.request.enumeration.Query;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdminJobsGetReq extends AbstractReq {
    @Override
    protected String uri() {
        return UriPath.GET_ADMIN_JOBS;
    }

    public static AdminJobsGetReq buidSyncReq(String startTime, String endTime) {
        //分页查询,每次100条
        Integer limit = 100;
        AdminJobsGetReq req = new AdminJobsGetReq();
        String filter = filter(startTime, endTime);
        req.putQuery(Query.FILTER, filter);
        req.putQuery(Query.PAGE_LIMIT, limit);
        return req;
    }

    private static String filter(String startTime, String endTime) {
        List<String> conditions = new ArrayList<>();
        if (!StringUtils.isEmpty(startTime)) {
            conditions.add("startTime ge " + startTime);
        }
        if (!StringUtils.isEmpty(endTime)) {
            conditions.add("endTime le " + endTime);
        }
        String filter = "";
        if (!conditions.isEmpty()) {
            filter += String.join(" and ", conditions).trim();
        }
        return filter;
    }
}
