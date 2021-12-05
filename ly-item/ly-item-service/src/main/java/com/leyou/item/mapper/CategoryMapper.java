package com.leyou.item.mapper;

import com.leyou.pojo.Category;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/17
 */
public interface CategoryMapper extends Mapper<Category>, IdListMapper<Category, Long> {
}
