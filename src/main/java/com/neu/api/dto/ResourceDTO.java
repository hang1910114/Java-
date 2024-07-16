package com.neu.api.dto;

import lombok.Data;

@Data
public class ResourceDTO {
    private String name;
    private Integer status;//
    private String url;
    private String description;
//    private Integer resourceTypeId;
    private String resourceTypeName;
    //前端
}
