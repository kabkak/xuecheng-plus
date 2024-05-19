package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Api(value = "课程分类编辑接口", tags = "课程分类编辑接口")
public class CourseCategoryController {

    @Resource
    private CourseCategoryService courseCategoryService;

    /**
     * 课程分类树形结构查询
     *
     * @return
     */
    @GetMapping("/course-category/tree-nodes")
    @ApiOperation("课程分类接口")
    public List<CourseCategoryTreeDto> queryTreeNodes() {
        return courseCategoryService.queryTreeNodesTwo("1");
    }


}