package com.github.lc.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageFileContentEntryExt extends ImageFileContentEntry{
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private String backupId;

    public ImageContentsAttributes  toImageContentsAttributes(){
        ImageContentsAttributes imageContentsAttributes = new ImageContentsAttributes();
        imageContentsAttributes.setAttributes(this);
        return imageContentsAttributes;
    }

}
