package com.github.lc.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageContentsUnion {
    private Image image;
    private List<ImageContentsAttributes> contentsAttributesList;
}
