package com.leyou.item.mapper;

import com.leyou.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/19
 */
public interface BrandMapper extends Mapper<Brand> {

    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid}, #{bid})")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

}
