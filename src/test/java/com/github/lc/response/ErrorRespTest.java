package com.github.lc.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class ErrorRespTest {

    @Test
    public void parseGetMsg() throws IOException {
        String str="{\"errorCode\":826,\"errorMessage\":\"operation not valid for this job\",\"details\":{}}";
        new ObjectMapper().readValue(str, ErrorResp.class);
    }
}