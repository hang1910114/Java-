package com.neu.api.controller.admin;


import com.neu.api.constant.ResourceStatus;
import com.neu.api.dto.ResourceDTO;
import com.neu.api.exception.ParamException;
import com.neu.api.mapper.ResourceMapper;
import com.neu.api.query.ResourceQuery;
import com.neu.api.service.ResourceService;
import com.neu.api.utils.PageResult;
import com.neu.api.utils.Result;
import com.neu.api.vo.ResourceTypeVO;
import com.neu.api.vo.ResourceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "资源接口")
@RestController
@RequestMapping("/admin/resource")
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @Resource
    ResourceMapper resourceMapper;

    @ApiOperation("查询资源")
    @GetMapping
    public Result<List<ResourceVO>> find(ResourceQuery resourceQuery){ //foodQuery封装了查询的条件
        PageResult<ResourceVO> page = resourceService.find(resourceQuery);
        return Result.ok("成功",page.getList(),page.getTotal());
    }

    @ApiOperation("根据name查询资源类型")
    @GetMapping("/{name}")
    public Result<List<ResourceTypeVO>> findName(@PathVariable String name) {
       List<ResourceVO> result = resourceService.findName(name);
        return Result.ok("成功",result);
    }

    @ApiOperation("添加项目资源")
    @PostMapping
    public Result add(ResourceDTO resourceDTO){
        resourceService.add(resourceDTO);
        return Result.ok("添加成功");
    }

    //根据分类添加
//    @ApiOperation("添加项目资源（分类）")
//    @PostMapping("/type")
//    public Result add1(ResourceDTO1 resourceDTO1){
//        resourceService.add1(resourceDTO1);
//        return Result.ok("添加成功");
//    }

    //
    @ApiOperation("编辑资源")
    @PutMapping("/{resouceTypeId}")
    public Result update(@PathVariable Integer resouceTypeId, ResourceDTO resourceDTO){ //@RequestBody将前端传递的json格式的请求参数转为对象
        resourceService.update(resouceTypeId,resourceDTO);
        return Result.ok("修改成功");
    }

    @ApiOperation("禁用启动资源")
    @PutMapping("/{id}/status")
    public Result updateStatus(@PathVariable Integer id, String status){
        if(ResourceStatus.DIS_ABLE.equals(status)){
            resourceMapper.updateStatus(id, ResourceStatus.DIS_ABLE0);
        }else if(ResourceStatus.EN_ABLE.equals(status)){
            resourceMapper.updateStatus(id, ResourceStatus.EN_ABLE1);
        }else{
            throw new ParamException("参数错误");
        }
        return Result.ok("修改状态成功");
    }
}
