package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class CatalogImagesRequestIdGetReq extends AbstractReq{
    public CatalogImagesRequestIdGetReq(String backupId){
        this.put("backupId",backupId);
    }

    @Override
    protected String uri() {
        return UriPath.GET_CATALOG_IMAGES_REQUESTID;
    }
}
