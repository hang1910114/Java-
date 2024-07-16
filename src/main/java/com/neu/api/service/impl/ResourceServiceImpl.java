package com.neu.api.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.api.dto.ResourceDTO;
import com.neu.api.dto.ResourceDTO1;
import com.neu.api.mapper.ResourceMapper;
import com.neu.api.pojo.ResourceDetail;
import com.neu.api.query.ResourceQuery;
import com.neu.api.service.ResourceService;
import com.neu.api.utils.PageResult;
import com.neu.api.utils.Result;
import com.neu.api.vo.ResourceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Resource
    ResourceMapper resourceMapper;
    
    @Override
    public PageResult<ResourceVO> find(ResourceQuery resourceQuery) {
        //设置是否需要分页
        PageHelper.startPage(resourceQuery.getPage(),resourceQuery.getPageSize());

        Page<ResourceVO> page = (Page<ResourceVO>) resourceMapper.find(resourceQuery);
        PageInfo<ResourceVO> pageInfo = page.toPageInfo();

        List<ResourceVO> resourceVOList = pageInfo.getList();
        long total = pageInfo.getTotal();

        PageResult<ResourceVO> pageResult = new PageResult<>();
        pageResult.setTotal(total);
        pageResult.setList(resourceVOList);

        return pageResult;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(Integer resourceTypeId , ResourceDTO resourceDTO) {
        ResourceDetail resourceDetail = new ResourceDetail();
        BeanUtils.copyProperties(resourceDTO,resourceDetail);

        resourceDetail.setId(resourceTypeId);
        resourceMapper.update(resourceDetail);
    }

    @Override
    public void add(ResourceDTO resourceDTO) {
        ResourceDetail resourceDetail = new ResourceDetail();
        BeanUtils.copyProperties(resourceDTO,resourceDetail);
        resourceMapper.add(resourceDetail);
    }


    ////////这里
    @Override
    public void add1(ResourceDTO1 resourceDTO1) {
        ResourceDetail resourceDetail = new ResourceDetail();
        BeanUtils.copyProperties(resourceDTO1,resourceDetail);
        resourceMapper.add1(resourceDetail);
    }

    @Override
    public void updateStatus(Integer id, String status) {   //
        ResourceDetail resourceDetail = new ResourceDetail();
        resourceDetail.setId(id);
        resourceDetail.setStatus(status);
        resourceMapper.updateStatus(id , status);
    }

    @Override
    public List<ResourceVO> findName(@PathVariable String name) {
        return resourceMapper.findName(name);
    }
}
