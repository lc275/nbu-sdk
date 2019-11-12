package com.github.lc.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginResp {
    private String token;
    private String tokenType;
    private Integer validity;
}
