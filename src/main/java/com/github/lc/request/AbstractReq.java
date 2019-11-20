package com.github.lc.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lc.request.enumeration.MIMEType;
import com.github.lc.request.enumeration.Query;
import com.github.lc.schema.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract request for subclass
 */
@Slf4j
public abstract class AbstractReq {

    private static final String NBU_GENERIC_SCHEMA = "X-NetBackup-Policy-Use-Generic-Schema";

    @JsonIgnore
    private Map<String, Object> uriVariables = new HashMap<>();

    /**
     * simply wraps the put method of uriVariables
     */
    public final void put(String key, Object value) {
        uriVariables.put(key, value);
    }

    /**
     * put typical query params included in Query enum.
     * for example <code>put(Query.PAGE_LIMIT,10)</code> have a same effect to <code> put("page[limit]",10)</code>
     */
    public final void putQuery(Query queryEnum, Object value) {
        put(queryEnum.getVariableName(), value);
    }

    /**
     * remove query params
     */
    public final Object removeQuery(Query queryEnum){
        return uriVariables.remove(queryEnum.getVariableName());
    }

    /**
     *
     * @return unmodifiable copy of uriVariables
     */
    public final Map<String, Object> getUriVariables() {
        return Collections.unmodifiableMap(uriVariables);
    }

    /**
     * get the complete request url
     * @param masterServerName masterServerName
     * @param port port
     * @return complete request url
     */

    public final String url(String masterServerName, int port) {
        String url = "https://" + masterServerName + ":" + port + "/netbackup" + uri();
        if (uriVariables.isEmpty()) {
            return url;
        }
        //append uriVariables
        String queryExpressionStr = Query.generateQueryString(uriVariables);
        if (StringUtils.hasLength(queryExpressionStr)) {
            url = url.contains("?") ? url + queryExpressionStr : url + "?" + queryExpressionStr;
        }
        log.info("request url:{}", url);
        return url;
    }

    /**
     * @return request uri
     */
    protected abstract String uri();

    /**
     * parsing the camel case class Name，and get the second last word as request method
     *
     * @return method to request
     */
    public final HttpMethod httpMethod() {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        String className = this.getClass().getSimpleName();
        String[] strArray = className.replaceAll(regex, replacement).toUpperCase().split("_");
        String methodStr = strArray[strArray.length - 2];
        HttpMethod resolvedMethod = HttpMethod.resolve(methodStr);
        if (resolvedMethod == null) {
            throw new IllegalArgumentException("http method is invalid:" + methodStr);
        }
        return resolvedMethod;
    }

    /**
     * if authorization header is needed,most api for true,but ping or login
     * @return
     */
    public boolean needAuthorization() {
        return true;
    }

    /**
     * request header "accept" format，default json，subclasses could override
     * @return
     */
    protected MIMEType acceptHeader() {
        return MIMEType.JSON;
    }

    /**
     * build the request header and body
     *
     * @param token
     * @return
     */
    public final HttpEntity httpEntity(String token) {
        String body = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            body = mapper.writeValueAsString(this);
        } catch (JsonProcessingException ignored) {
            log.error("ObjectMapper serialization occurs exception，probably the object has no property,could be ignored", ignored);
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MIMEType.JSON.getValue());
        httpHeaders.add(HttpHeaders.ACCEPT, acceptHeader().getValue());
        if (addNbuGenericSchema()) {
            httpHeaders.add(NBU_GENERIC_SCHEMA, "true");
        }
        if (needAuthorization()) {
            httpHeaders.add("Authorization", token);
        }
        log.info("request body:{},headers:{}", body, httpHeaders);
        return new HttpEntity(body, httpHeaders);
    }

    protected boolean addNbuGenericSchema() {
        return false;
    }

    /**
     * set the request params to next page
     * @param pagination
     */
    public void nextPage(Pagination pagination) {
        this.putQuery(Query.PAGE_OFFSET, pagination.getNext());
    }
}
