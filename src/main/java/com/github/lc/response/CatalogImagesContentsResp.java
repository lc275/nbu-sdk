package com.github.lc.response;

import com.github.lc.schema.ImageContentsAttributes;
import com.github.lc.schema.Meta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * /catalog/images/contents/{requestId} 接口响应
 *
 * ImageContentsAttributes->ImageFileContentEntry
 */
@Setter
@Getter
public class CatalogImagesContentsResp implements ListableResp<ImageContentsAttributes>{
    private List<ImageContentsAttributes> data;
    private Meta meta;
}
