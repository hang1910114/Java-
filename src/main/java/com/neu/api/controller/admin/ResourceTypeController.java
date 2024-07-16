package com.neu.api.controller.admin;


import com.neu.api.dto.ResourceTypeDTO;
import com.neu.api.query.ResourceTypeQuery;
import com.neu.api.service.ResourceTypeService;
import com.neu.api.utils.PageResult;
import com.neu.api.utils.Result;
import com.neu.api.vo.ResourceTypeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "课程分类接口")
@RestController
@RequestMapping("/admin/resourceType")
public class ResourceTypeController {

    @Resource
    ResourceTypeService resourceTypeService;


    @ApiOperation("查询资源分类")
    @GetMapping
    public Result<List<ResourceTypeVO>> find(ResourceTypeQuery resourceTypeQuery){ //foodQuery封装了查询的条件
        PageResult<ResourceTypeVO> page = resourceTypeService.find(resourceTypeQuery);
        return Result.ok("成功",page.getList(),page.getTotal());
    }

    //项目类型查询
    @ApiOperation("根据name查询资源类型")
    @GetMapping("/{name}")
    public Result<ResourceTypeVO> findName(@PathVariable String name) {
        ResourceTypeVO resourceTypeVO = resourceTypeService.findName(name);
        return Result.ok("成功",resourceTypeVO);
    }

    //
    @ApiOperation("编辑分类")
    @PutMapping("/{id}")
    public Result update(@PathVariable int id, ResourceTypeDTO resourceTypeDTO){ //@RequestBody将前端传递的json格式的请求参数转为对象
        resourceTypeService.update(id,resourceTypeDTO);
        return Result.ok("修改成功");
    }

    @ApiOperation("添加分类")
    @PostMapping
    public Result add(ResourceTypeDTO resourceTypeDTO){
        resourceTypeService.add(resourceTypeDTO);
        return Result.ok("添加成功");
    }

    @ApiOperation("删除分类")
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        resourceTypeService.deleteById1(id);
        resourceTypeService.deleteById(id);
        return Result.ok("删除成功");
    }
}
