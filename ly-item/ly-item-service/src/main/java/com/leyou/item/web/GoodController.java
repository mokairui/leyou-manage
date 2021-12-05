package com.leyou.item.web;

import com.leyou.common.vo.PageResult;
import com.leyou.item.service.GoodService;
import com.leyou.pojo.Spu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/23
 */
@RestController
@RequestMapping("/")
public class GoodController {

    @Resource
    private GoodService goodService;

    @GetMapping("/spu/page")
    public ResponseEntity<PageResult<Spu>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "key", required = false) String key
    ) {
        return ResponseEntity.ok(goodService.querySpuByPage(page, rows, saleable, key));
    }

}
