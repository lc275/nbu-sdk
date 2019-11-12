package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class CatalogImagesContentsGetReq extends AbstractReq {

    public CatalogImagesContentsGetReq(String requestId){
        this.put("requestId",requestId);
    }

    @Override
    protected String uri() {
        return UriPath.GET_CATALOG_IMAGES_CONTENTS;
    }
}
