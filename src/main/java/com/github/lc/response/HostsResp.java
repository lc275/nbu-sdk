package com.github.lc.response;

import com.github.lc.schema.host.Host;
import lombok.Data;

import java.util.List;

@Data
public class HostsResp {
    private List<Host> hosts;
}
