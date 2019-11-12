package com.github.lc.response;

import com.github.lc.schema.Meta;

import java.util.List;

public interface ListableResp<D> {
    List<D> getData();
    Meta getMeta();
}
