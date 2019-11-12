package com.github.lc.request.enumeration;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
public enum Query {


    FILTER("filter={filter}","filter"),
    PAGE_LIMIT("page[limit]={page[limit]}","page[limit]"),
    PAGE_OFFSET("page[offset]={page[offset]}","page[offset]"),
    SORT("sort={sort}","sort");

    private String expression;
    private String variableName;
    Query(String expression,String variableName){
        this.expression=expression;
        this.variableName = variableName;
    }
    public static String generateQueryString(Map<String,Object> uriVariables){
        Query[] queryEnums = Query.values();
        StringBuilder queryExpression = new StringBuilder();
        uriVariables.forEach((key, value) -> {
            Arrays.stream(queryEnums)
                    .filter(q -> q.getVariableName().equals(key))//包含诸如filter,sort,page[offset],page[limit] 等参数
                    .forEach(q -> queryExpression.append("&").append(q.getExpression()));
        });
        return queryExpression.toString();
    }



}
