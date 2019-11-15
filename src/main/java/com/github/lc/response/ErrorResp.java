package com.github.lc.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Getter
@Setter
@ToString
@Slf4j
public class ErrorResp {
    /*
    A map containing error field and error field message to provide more context to nature of the error
    * */
    private Object details;
    /**
     * The NetBackup error code
     */
    private Integer errorCode;
    /*
    The NetBackup error code description.
    * */
    private String errorMessage;

    public static String parseErrorBody(String body) {
        ErrorResp error = null;
        try {
            error = new ObjectMapper().readValue(body, ErrorResp.class);
        } catch (IOException e) {
            log.error("parse nbu error with exception：{}", body);
        }
        return error==null?"call netbackup api return with exception": error.toString();
    }

}
