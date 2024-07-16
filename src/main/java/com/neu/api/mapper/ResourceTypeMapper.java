package com.neu.api.mapper;


import com.neu.api.dto.ResourceTypeDTO;
import com.neu.api.pojo.ResourceType;
import com.neu.api.query.ResourceTypeQuery;
import com.neu.api.vo.ResourceTypeVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ResourceTypeMapper {

    List<ResourceTypeVO> find(ResourceTypeQuery resourceTypeQuery);

    void update(ResourceType resourceType);

    ResourceTypeVO findName(String name);

    //添加分类
    void add(ResourceTypeDTO resourceTypeDTO);
    //
    @Select("select * from t_resource_type")
    List<ResourceType> findResourceTypeId();
    //
    @Delete("delete from t_resource_type where id = #{id}")
    void deleteById(Integer id);
    @Delete("delete from t_resource where resource_type_id=#{id}")
    void deleteById1(Integer id);
}
