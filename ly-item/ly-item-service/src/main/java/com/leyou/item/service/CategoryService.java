package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.pojo.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/17
 */
@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long id) {
        Category category = new Category();
        category.setParentId(id);
        return categoryMapper.select(category);
    }
}
