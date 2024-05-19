package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.model.po.CourseCategory;
import com.xuecheng.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;


    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {

        LambdaQueryWrapper<CourseCategory> categoryOne = new LambdaQueryWrapper<CourseCategory>().eq(CourseCategory::getParentid, id);
        List<CourseCategory> categoryOneList = courseCategoryMapper.selectList(categoryOne);
        List<CourseCategoryTreeDto> categoryTreeDtos = new ArrayList<>(categoryOneList.size());

        categoryOneList.stream().forEach(item -> {
            CourseCategoryTreeDto courseCategoryTreeDto = new CourseCategoryTreeDto();
            BeanUtils.copyProperties(item, courseCategoryTreeDto);

            List<CourseCategory> categoryTwoList = courseCategoryMapper.selectList(new LambdaQueryWrapper<CourseCategory>().eq(CourseCategory::getParentid, item.getId()));

            courseCategoryTreeDto.setChildrenTreeNodes(categoryTwoList);

            categoryTreeDtos.add(courseCategoryTreeDto);
        });
        return categoryTreeDtos;
    }

    @Override
    public List<CourseCategoryTreeDto> queryTreeNodesTwo(String id) {
        return courseCategoryMapper.selectTreeNodesTwo(id);
    }

    public List<CourseCategoryTreeDto> queryTreeNodes2(String id) {
        List<CourseCategoryTreeDto> categoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);
        List<CourseCategoryTreeDto> result = new ArrayList<>();
        categoryTreeDtos.stream().forEach(item -> {
        });
        return result;
    }


    public List<CourseCategoryTreeDto> queryTreeNodes1(String id) {
        // 获取所有的子节点
        List<CourseCategoryTreeDto> categoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);
        // 定义一个List，作为最终返回的数据
        List<CourseCategoryTreeDto> result = new ArrayList<>();
        // 为了方便找子节点的父节点，这里定义一个HashMap，key是节点的id，value是节点本身
        HashMap<String, CourseCategoryTreeDto> nodeMap = new HashMap<>();
        // 将数据封装到List中，只包括根节点的下属节点（1-1、1-2 ···），这里遍历所有节点
        categoryTreeDtos.stream().forEach(item -> {
            // 这里寻找父节点的直接下属节点（1-1、1-2 ···）
            if (item.getParentid().equals(id)) {
                nodeMap.put(item.getId(), item);
                result.add(item);
            }
            // 获取每个子节点的父节点
            String parentid = item.getParentid();
            CourseCategoryTreeDto parentNode = nodeMap.get(parentid);
            // 判断HashMap中是否存在该父节点（按理说必定存在，以防万一）
            if (parentNode != null) {
                // 为父节点设置子节点（将1-1-1设为1-1的子节点）
                List childrenTreeNodes = parentNode.getChildrenTreeNodes();
                // 如果子节点暂时为null，则初始化一下父节点的子节点（给个空集合就行）
                if (childrenTreeNodes == null) {
                    parentNode.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDto>());
                }
                // 将子节点设置给父节点
                parentNode.getChildrenTreeNodes().add(item);
            }
        });
        // 返回根节点的直接下属节点（1-1、1-2 ···）
        return result;
    }
}
