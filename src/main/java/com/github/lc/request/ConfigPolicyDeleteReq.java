package com.github.lc.request;

import com.github.lc.request.path.UriPath;

public class ConfigPolicyDeleteReq extends AbstractReq {
    @Override
    public String uri() {
        return UriPath.DELETE_CONFIG_POLICY;
    }

    public ConfigPolicyDeleteReq(Object policyName){
        this.put("policyName",policyName);
    }
}
