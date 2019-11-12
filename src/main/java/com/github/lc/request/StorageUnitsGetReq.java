package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class StorageUnitsGetReq extends AbstractReq {
    @Override
    protected String uri() {
        return UriPath.GET_STORAGE_UNITS;
    }
}
