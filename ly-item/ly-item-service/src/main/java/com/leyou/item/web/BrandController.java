package com.leyou.item.web;

import com.leyou.common.vo.PageResult;
import com.leyou.item.service.BrandService;
import com.leyou.pojo.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/19
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private BrandService brandService;

    /**
     * 根据分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key
    ) {
        return ResponseEntity.ok(brandService.queryBrandByPage(page, rows, sortBy, desc, key));
    }

    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand,
                                          @RequestParam("cids") List<Long> cids) {
        brandService.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
