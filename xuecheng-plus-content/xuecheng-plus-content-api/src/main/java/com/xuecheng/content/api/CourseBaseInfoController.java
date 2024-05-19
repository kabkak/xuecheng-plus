package com.xuecheng.content.api;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.QueryCourseParamDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Api(value = "课程信息编辑接口", tags = "课程信息编辑接口")
public class CourseBaseInfoController {
    @Resource
    private CourseBaseInfoService courseBaseInfoService;

    @PostMapping("/course/list")
    @ApiOperation("课程查询接口")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody QueryCourseParamDto queryCourseParams) {
        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(null, pageParams, queryCourseParams);
        return courseBasePageResult;

    }

    @PostMapping("/course")
    @ApiOperation("课程添加接口")
    public CourseBaseInfoDto createCourse(@RequestBody @Validated AddCourseDto addCourseDto) {

        CourseBaseInfoDto courseBaseInfoDto = courseBaseInfoService.createCourseBase(1L,addCourseDto);
        return courseBaseInfoDto;
    }
    @ApiOperation("删除课程")
    @DeleteMapping("/course/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        Long companyId = 1232141425L;
        courseBaseInfoService.delectCourse(companyId,courseId);
    }
    @ApiOperation("根据课程id查询课程基础信息")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseById(@PathVariable Long courseId) {
        return courseBaseInfoService.getCourseBaseInfo(courseId);
    }
}