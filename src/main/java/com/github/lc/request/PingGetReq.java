package com.github.lc.request;

import com.github.lc.request.path.UriPath;
import com.github.lc.request.enumeration.MIMEType;

public class PingGetReq extends AbstractReq {
    @Override
    protected String uri() {
        return UriPath.GET_PING;
    }

    @Override
    public boolean needAuthorization() {
        return false;
    }

    @Override
    protected MIMEType acceptHeader() {
        return MIMEType.TEXT;
    }
}
