package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class CatalogImagesContentDeleteReq extends AbstractReq {

    public CatalogImagesContentDeleteReq(Object requestId){
        this.put("requestId",requestId);
    }

    @Override
    protected String uri() {
        return UriPath.DELETE_CATALOG_IMAGES_CONTENT;
    }
}
