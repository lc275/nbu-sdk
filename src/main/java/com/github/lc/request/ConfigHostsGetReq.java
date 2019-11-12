package com.github.lc.request;


import com.github.lc.request.path.UriPath;

public class ConfigHostsGetReq extends AbstractReq {
    @Override
    protected String uri() {
        return UriPath.GET_CONFIG_HOSTS;
    }

}
