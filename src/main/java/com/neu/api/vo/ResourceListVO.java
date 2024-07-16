package com.neu.api.vo;

import lombok.Data;

@Data
public class ResourceListVO {
    private Integer id;
    private String resourceTypeName;
    private Integer sort;
    private String url;
    private String description;
    private byte status; ///
}
