package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class ConfigSlpsGetReq extends AbstractReq {
    @Override
    protected String uri() {
        return UriPath.GET_CONFIG_SLPS;
    }
}
