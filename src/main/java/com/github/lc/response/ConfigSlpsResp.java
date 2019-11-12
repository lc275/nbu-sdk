package com.github.lc.response;

import com.github.lc.schema.SlpDefinition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ConfigSlpsResp {
    private List<SlpDefinition> data;
}
