package com.github.lc.request;

import com.github.lc.request.path.UriPath;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginPostReq extends AbstractReq {
    private String domainType;
    private String domainName;
    private String userName;
    private String password;

    @Override
    public String uri() {
        return UriPath.POST_NETBACKUP_LOGIN;
    }

    @Override
    public boolean needAuthorization() {
        return false;
    }

}
