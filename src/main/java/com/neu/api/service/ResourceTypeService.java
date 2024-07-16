package com.neu.api.service;

import com.neu.api.dto.ResourceTypeDTO;
import com.neu.api.query.ResourceTypeQuery;
import com.neu.api.utils.PageResult;
import com.neu.api.vo.ResourceTypeVO;
import org.apache.ibatis.annotations.Delete;

import java.util.List;


public interface ResourceTypeService {
    PageResult<ResourceTypeVO> find(ResourceTypeQuery resourceTypeQuery);

//    List<ResourceType> findResourceTypeId();
//
    List<ResourceTypeVO> findResourceType(String name);

    ResourceTypeVO findName(String name);

    void update(int id,ResourceTypeDTO resourceTypeDTO);

    void add(ResourceTypeDTO resourceTypeDTO);

    @Delete("delete from t_resource_type where id=#{id}")
    void deleteById(Integer id);

    @Delete("delete from t_resource where resource_type_id=#{id}")
    void deleteById1(Integer id);
}
