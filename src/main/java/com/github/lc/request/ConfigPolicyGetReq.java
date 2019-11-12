package com.github.lc.request;

import com.github.lc.request.path.UriPath;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfigPolicyGetReq  extends AbstractReq{
    @Override
    public String uri() {
        return UriPath.GET_CONFIG_POLICY;
    }

    public ConfigPolicyGetReq(Object policyName){
        this.put("policyName",policyName);
    }

    private boolean nbuGenericSchema;

    @Override
    public boolean addNbuGenericSchema(){
        return nbuGenericSchema;
    }
}
