package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.SpuMapper;
import com.leyou.pojo.Category;
import com.leyou.pojo.Spu;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/23
 */
@Service
public class GoodService {
    @Resource
    private SpuMapper spuMapper;
    @Resource
    private CategoryService categoryService;
    @Resource
    private BrandService brandService;
    @Resource
    private AmqpTemplate amqpTemplate;

    public PageResult<Spu> querySpuByPage(Integer page, Integer rows, Boolean saleable, String key) {
        // 分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(Spu.class);
        // 搜索字段过滤
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("title", "%" + key + "%");
        }
        // 上下架过滤
        if (saleable != null) {
            criteria.andEqualTo("saleable", saleable);
        }
        // 默认排序
        example.setOrderByClause("last_update_time DESC");
        // 查询
        List<Spu> spuList = spuMapper.selectByExample(example);
        // 判断
        if (spuList.isEmpty()) {
            throw new LyException(ExceptionEnum.GOODS_NOT_FOUND);
        }

        // 解析分类和品牌的名称
        loadCategoryAndBrandName(spuList);

        // 解析分页结果
        PageInfo<Spu> pageInfo = new PageInfo<>(spuList);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    private void loadCategoryAndBrandName(List<Spu> spuList) {
        for (Spu spu : spuList) {
            // 处理分类名称
            List<String> nameList = categoryService.queryByIds(
                    Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()))
                    .stream().map(Category::getName).collect(Collectors.toList());
            spu.setCname(StringUtils.join(nameList, "/"));
            // 处理品牌名称
            spu.setBname(brandService.queryById(spu.getBrandId()).getName());
        }
    }

    @Transactional
    public void updateGoods(Spu spu) {
        // ... 修改 spu

        amqpTemplate.convertAndSend("item.update", spu.getId());
    }
}
