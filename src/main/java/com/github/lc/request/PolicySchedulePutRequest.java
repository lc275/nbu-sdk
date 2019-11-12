package com.github.lc.request;

import com.github.lc.request.path.UriPath;
import com.github.lc.schema.schedule.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@lombok.Data
public class PolicySchedulePutRequest extends AbstractReq{
    @Override
    public String uri() {
        return UriPath.PUT_POLICY_SCHEDULE;
    }

    public void putValue(Object policyName, Object scheduleName){
        this.put("policyName",policyName);
        this.put("scheduleName",scheduleName);
    }

    private Data data;
}
