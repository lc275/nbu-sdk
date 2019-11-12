package com.github.lc.request;

import com.github.lc.request.path.UriPath;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfigPolicyPutReq  extends AbstractReq{
    @Override
    public String uri() {
        return UriPath.PUT_CONFIG_POLICY;
    }

    public ConfigPolicyPutReq(Object policyName){
        this.put("policyName",policyName);
    }

    @Override
    public boolean addNbuGenericSchema(){
        return nbuGenericSchema;
    }

    private com.github.lc.schema.policy.Data data;

    private boolean nbuGenericSchema;

}