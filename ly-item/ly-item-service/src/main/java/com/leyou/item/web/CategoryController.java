package com.leyou.item.web;

import com.leyou.item.service.CategoryService;
import com.leyou.pojo.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/17
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 根据父节点id查询商品分类
     * @param id
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByPid(
            @RequestParam(value = "pid", required = false) Long id
    ) {
        return ResponseEntity.ok(categoryService.queryCategoryListByPid(id));
    }

}
