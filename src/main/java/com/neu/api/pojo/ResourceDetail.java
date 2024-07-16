package com.neu.api.pojo;

import lombok.Data;

@Data
public class ResourceDetail {
    private Integer id;
    private String name;
    private Integer resourceTypeId;
    private String url;
    private String status;///
    private String description;
    private String resourceTypeName;
}
