package com.neu.api.utils;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private List<T> list;

    private long total;
}
