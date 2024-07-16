package com.neu.api.vo;

import lombok.Data;

@Data
public class ResourceVO{
    private Integer id;
    private String name;
    private String url;
    private Integer status; //
    private String description;
    private String resourceTypeName;
    private Integer resourceTypeId;
}
