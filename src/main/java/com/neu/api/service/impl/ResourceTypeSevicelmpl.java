package com.neu.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.api.dto.ResourceTypeDTO;
import com.neu.api.mapper.ResourceTypeMapper;
import com.neu.api.pojo.ResourceType;
import com.neu.api.query.ResourceTypeQuery;
import com.neu.api.service.ResourceTypeService;
import com.neu.api.utils.PageResult;
import com.neu.api.vo.ResourceTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class ResourceTypeSevicelmpl implements ResourceTypeService {

    @Resource
    ResourceTypeMapper resourceTypeMapper;

    @Override
    public PageResult<ResourceTypeVO> find(ResourceTypeQuery resourceTypeQuery) {
        //设置是否需要分页
        PageHelper.startPage(resourceTypeQuery.getPage(),resourceTypeQuery.getPageSize());

        Page<ResourceTypeVO> page = (Page<ResourceTypeVO>) resourceTypeMapper.find(resourceTypeQuery);
        PageInfo<ResourceTypeVO> pageInfo = page.toPageInfo();

        List<ResourceTypeVO> resourceTypeVOList = pageInfo.getList();
        long total = pageInfo.getTotal();

        PageResult<ResourceTypeVO> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setList(resourceTypeVOList);

        return pageResult;
    }

    @Override
    public List<ResourceTypeVO> findResourceType(String name) {
        return Collections.emptyList();
    }

    @Override
    public ResourceTypeVO findName(String name) {
        return resourceTypeMapper.findName(name);
    }

    @Override
    public void update(int id,ResourceTypeDTO resourceTypeDTO) {
        ResourceType resourceType = new ResourceType();
        BeanUtils.copyProperties(resourceTypeDTO,resourceType);

        resourceType.setId(id);
        resourceTypeMapper.update(resourceType);
    }


    @Override
    public void add(ResourceTypeDTO resourceTypeDTO) {
        ResourceType resourceType = new ResourceType();
        BeanUtils.copyProperties(resourceTypeDTO,resourceType);
        resourceTypeMapper.add(resourceTypeDTO);
    }

    @Override
    public void deleteById(Integer id) {
        resourceTypeMapper.deleteById(id);
    }

    @Override
    public void deleteById1(Integer id) {
        resourceTypeMapper.deleteById1(id);
    }
}
