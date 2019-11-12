package com.github.lc.response;

import com.github.lc.schema.StorageUnitDefinition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class StorageUnitsResp {
    private List<StorageUnitDefinition> data;
}
