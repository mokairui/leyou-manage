package com.leyou.item.web;

import com.leyou.item.service.SpecificationService;
import com.leyou.pojo.SpecGroup;
import com.leyou.pojo.SpecParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/23
 */
@RestController
@RequestMapping("/spec")
public class SpecificationController {
    @Resource
    private SpecificationService specificationService;

    /**
     * 根据分类 id 查询规格分组
     * @param cid
     * @return
     */
    @GetMapping("/groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid") Long cid) {
        return ResponseEntity.ok(specificationService.queryGroupByCid(cid));
    }

    /**
     * 根据组 id 查询参数
     * @param gid
     * @return
     */
    @GetMapping("/params")
    public ResponseEntity<List<SpecParam>> queryParamByGid(@PathVariable("gid") Long gid) {
        return ResponseEntity.ok(specificationService.queryParamByGid(gid));
    }
}
