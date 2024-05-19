package com.xuecheng.content;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试使用feign远程上传文件
 */
@SpringBootTest
public class FeignUploadTest {
    @Resource
    private CourseCategoryMapper courseCategoryMapper;

    //远程调用，上传文件
    @Test
    public void test() {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryMapper.selectTreeNodesTwo("1");
        System.out.println(courseCategoryTreeDtos);
    }
}