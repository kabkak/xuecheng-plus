package com.xuecheng.content.service.impl;

import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.mapper.CourseMarketMapper;
import com.xuecheng.content.mapper.CoursePublishMapper;
import com.xuecheng.content.mapper.CoursePublishPreMapper;
import com.xuecheng.content.model.dto.CoursePreviewDto;
import com.xuecheng.content.model.po.CoursePublish;
import com.xuecheng.content.service.CourseBaseInfoService;
import com.xuecheng.content.service.CoursePublishService;
import com.xuecheng.content.service.TeachplanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
public class CoursePublishServiceImpl implements CoursePublishService {
    @Autowired
    private CourseBaseInfoService courseBaseInfoService;
    @Autowired
    private TeachplanService teachplanService;
    @Autowired
    private CourseMarketMapper courseMarketMapper;
    @Autowired
    private CoursePublishPreMapper coursePublishPreMapper;
    @Autowired
    private CourseBaseMapper courseBaseMapper;
    @Autowired
    private CoursePublishMapper coursePublishMapper;

    @Override
    public CoursePreviewDto getCoursePreviewInfo(Long courseId) {
        return null;
    }

    @Override
    public void commitAudit(Long companyId, Long courseId) {

    }

    @Override
    public void publishCourse(Long companyId, Long courseId) {

    }

    @Override
    public File generateCourseHtml(Long courseId) {
        return null;
    }

    @Override
    public void uploadCourseHtml(Long courseId, File file) {

    }

    @Override
    public Boolean saveCourseIndex(Long courseId) {
        return null;
    }

    @Override
    public CoursePublish getCoursePublish(Long courseId) {
        return null;
    }

    @Override
    public CoursePublish getCoursePublishCache(Long courseId) {
        return null;
    }
}
