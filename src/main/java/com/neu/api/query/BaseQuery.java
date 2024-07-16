package com.neu.api.query;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class BaseQuery {
    private int page=1;
    private int pageSize=10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if(page<=0){
            page=1;
        }
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize<=0){
            pageSize=10;
        }else if(pageSize>=100){
            pageSize=100;
        }

        this.pageSize = pageSize;
    }
}
