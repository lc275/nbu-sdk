package com.github.lc.response;

import com.github.lc.schema.Image;
import com.github.lc.schema.Meta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CatalogImagesResp implements ListableResp<Image> {
    private List<Image> data;
    private Meta meta;
}
