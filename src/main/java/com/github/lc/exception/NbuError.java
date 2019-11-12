package com.github.lc.exception;

import lombok.Getter;

@Getter
public enum NbuError {
    JOB_OPERATION_NOT_VALID(826,"该任务不支持此操作");
    private Integer errorCode;
    private String msg;
    NbuError(Integer errorCode,String msg){
        this.errorCode=errorCode;
        this.msg=msg;
    }
    public static String getMsgByCode(Integer errorCode){
        NbuError[] values = NbuError.values();
        for (NbuError e:values){
            if(e.getErrorCode().equals(errorCode)){
                return e.getMsg();
            }
        }
        return null;
    }
}
