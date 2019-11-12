package com.github.lc.schema;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageContentsAttributes {
    private ImageFileContentEntry attributes;
    private String id;
    private String type;
}
