package com.github.lc.schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorageUnitDefinition {
    private StorageUnitAttributes attributes;
    private String id;
    private String type;
}
