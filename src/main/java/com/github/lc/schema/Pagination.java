package com.github.lc.schema;

import lombok.Getter;
import lombok.Setter;

/**
 * nbu 分页信息
 */
@Getter
@Setter
public class Pagination {
    /*下一页的偏移量*/
    private Integer next;
    /*总页数*/
    private Integer pages;
    /*最后一页的偏移量*/
    private Integer last;
    /*当前页的偏移量*/
    private Integer offset;
    /*每页条数*/
    private Integer limit;
    /*总条目数*/
    private Integer count;
    /*当前页码*/
    private Integer page;
    /*首页偏移量*/
    private Integer first;

    /**
     * 是否最后一页
     */
    public boolean ifLastPage() {
        return offset.equals(last)|| (offset + limit == count);
    }

    public boolean ifEmpty() {
        return count == 0;
    }


}
