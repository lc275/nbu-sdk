package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class StorageUnitsReplicaRelaGetReq  extends AbstractReq{
    @Override
    protected String uri() {
        return UriPath.GET_STORAGE_UNITS_REPLICATION_RELATIONSHIP;
    }
}
