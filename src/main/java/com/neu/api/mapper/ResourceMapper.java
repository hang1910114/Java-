package com.neu.api.mapper;

import com.neu.api.pojo.ResourceDetail;
import com.neu.api.pojo.ResourceType;
import com.neu.api.query.ResourceQuery;
import com.neu.api.vo.ResourceVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface ResourceMapper {

    List<ResourceVO> find(ResourceQuery resourceQuery);

    //查找所有项目资源
    @Select("select * from t_resource")
    List<ResourceDetail> findAll();

    //根据name找资源
    @Select("select * from t_resource where name=#{name}")
    List<ResourceDetail> findResourceId(String name);

    //添加项目资源
    void add(ResourceDetail resourceDetail);
    //
    @Delete("delete from t_resource_type where name =#{name} and sort = #{sort} ")
    void deleteByName(String name,int sort);
    //
    @Select("select * from t_resource_type")
    List<ResourceType> findResourceTypeId();
    //
    @Select("select * from t_resource_type where name = #{name} and sort=#{sort}")
    List<ResourceType> findResourceType(String name,int sort);

    void update(ResourceDetail resourceDetail);

    @Update("update t_resource set status=#{status} where id=#{id}")
    void updateStatus(Integer id, String status);//

    void add1(ResourceDetail resourceDetail);//////////

    List<ResourceVO> findName(String name);
}
