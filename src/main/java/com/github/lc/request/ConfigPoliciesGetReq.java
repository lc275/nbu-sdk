package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class ConfigPoliciesGetReq extends AbstractReq {
    @Override
    public String uri() {
        return UriPath.GET_CONFIG_POLICIES;
    }
}
