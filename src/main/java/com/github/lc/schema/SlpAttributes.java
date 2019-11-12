package com.github.lc.schema;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class SlpAttributes {
    private String slpName;
    private List<SlpOperationDefinition> operationList;
}
