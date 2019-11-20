package com.github.lc.http;

import com.github.lc.exception.StatusCodeExceptionHandler;
import com.github.lc.request.AbstractReq;
import com.github.lc.request.TokenProvider;
import com.github.lc.response.ListableResp;
import com.github.lc.schema.Pagination;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.function.Consumer;

@Slf4j
@Getter
public class ApiClient {
    private static RestTemplate restTemplate;

    private TokenProvider tokenProvider;

    private String masterIpAddress;

    private int port;

    public ApiClient(String masterIpAddress, int port, TokenProvider tokenProvider) {
        Assert.hasLength(masterIpAddress, "master ip can not be null");
        Assert.notNull(tokenProvider, "token provider can not be null");
        this.masterIpAddress = masterIpAddress;
        this.tokenProvider = tokenProvider;
        this.port = port;
    }

    static {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClientUtils.acceptsUntrustedCertsHttpClient();
        } catch (KeyStoreException | NoSuchAlgorithmException | KeyManagementException e) {
            log.error("initialize nbu-sdk client occurs exception:", e);
        }
        HttpComponentsClientHttpRequestFactory httpsFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        httpsFactory.setReadTimeout(60000);
        httpsFactory.setConnectTimeout(5000);
        restTemplate = new RestTemplate(httpsFactory);
        restTemplate.setErrorHandler(new StatusCodeExceptionHandler());
    }

    /**
     * execute request and get respoonse of type T
     *
     * @param request   request to be executed
     * @param respClass class of response type
     * @param <T>       responseType
     * @return
     */
    public <T> T execute(AbstractReq request, Class<T> respClass) {
        log.info("request params:{}", request.getUriVariables());
        String token = token(request);
        ResponseEntity<T> resp = restTemplate.exchange(request.url(masterIpAddress, port), request.httpMethod(), request.httpEntity(token), respClass, request.getUriVariables());
        return resp.getBody();
    }

    /**
     * @param req
     * @return token if need to authorize else return null
     */
    private String token(AbstractReq req) {
        String token = tokenProvider.getToken(masterIpAddress);
        if (req.needAuthorization()) {
            Assert.notNull(token, "could not get token of netbackup master:" + masterIpAddress);
        }
        return req.needAuthorization() ? token : null;
    }

    /**
     * loop to request data,if current response is not the last page,then modify the pageOffset param and continue to request
     *
     * @param req   request
     * @param clazz class of response
     * @param c     consumer used to process response data
     * @param <R>   type of response,which should be a subclass of ListableResp
     */
    public <R extends ListableResp> void loopToEnd(AbstractReq req, Class<R> clazz, Consumer<R> c) {
        while (true) {
            R resp = this.execute(req, clazz);
            Pagination pagination = resp.getMeta().getPagination();
            if (pagination.ifEmpty()) {
                break;
            }
            c.accept(resp);
            if (pagination.ifLastPage()) {
                break;
            }
            req.nextPage(pagination);
        }
    }

}
