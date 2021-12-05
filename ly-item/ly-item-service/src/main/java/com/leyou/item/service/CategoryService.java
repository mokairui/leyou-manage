package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.pojo.Category;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        List<Category> list = categoryMapper.select(category);
        // 判断结果
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return list;
    }

    public List<Category> queryByIds(List<Long> ids) {
        List<Category> list = categoryMapper.selectByIdList(ids);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        return list;
    }
}
