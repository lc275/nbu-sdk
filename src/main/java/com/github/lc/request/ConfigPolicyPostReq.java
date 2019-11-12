package com.github.lc.request;

import com.github.lc.request.path.UriPath;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfigPolicyPostReq extends AbstractReq {

    @Override
    public String uri() {
        return UriPath.POST_CONFIG_POLICY;
    }

    @Override
    public boolean addNbuGenericSchema(){
           return nbuGenericSchema;
    }

    private com.github.lc.schema.policy.Data data;

    private boolean nbuGenericSchema;

}