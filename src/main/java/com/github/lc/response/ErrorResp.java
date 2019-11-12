package com.github.lc.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lc.exception.NbuError;
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

    public static String parseGetMsg(String errorStr) {
        ErrorResp error = null;
        try {
            error = new ObjectMapper().readValue(errorStr, ErrorResp.class);
        } catch (IOException e) {
            log.error("解析nbu返回的异常信息错误：{}", errorStr);
        }
        String resolvedMsg = NbuError.getMsgByCode(error.getErrorCode());
        return error==null?"调用netbackup异常": (resolvedMsg==null?error.getErrorMessage():resolvedMsg);
    }
}
