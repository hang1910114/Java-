package com.neu.api.service;

import com.neu.api.dto.ResourceDTO;
import com.neu.api.dto.ResourceDTO1;
import com.neu.api.query.ResourceQuery;
import com.neu.api.utils.PageResult;
import com.neu.api.utils.Result;
import com.neu.api.vo.ResourceVO;

import java.util.List;


public interface ResourceService {
    PageResult<ResourceVO> find(ResourceQuery resourceQuery);

    void deleteById(long id);

    void update(Integer resouceTypeId, ResourceDTO resourceDTO);

    void add(ResourceDTO resourceDTO);

    void add1(ResourceDTO1 resourceDTO1);

    void updateStatus(Integer id, String status);     //

    List<ResourceVO> findName(String name);
}
