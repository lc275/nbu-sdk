package com.github.lc.exception;

import com.github.lc.response.ErrorResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.IOException;
@Slf4j
public class StatusCodeExceptionHandler extends DefaultResponseErrorHandler {
    @Override
    protected void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {
        try{
            super.handleError(response, statusCode);
        }catch(HttpStatusCodeException e){
            HttpStatus status = e.getStatusCode();
            String body = e.getResponseBodyAsString();
            log.error("call nbu with exception,status code：{},exception info:{}",status,body);
            //rethrow exception
            throw new ServerClientException(ErrorResp.parseErrorBody(body));
        }
    }
}
