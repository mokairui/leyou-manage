package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.pojo.SpecGroup;
import com.leyou.pojo.SpecParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/23
 */
@Service
public class SpecificationService {

    @Resource
    private SpecGroupMapper specGroupMapper;

    @Resource
    private SpecParamMapper specParamMapper;

    public List<SpecGroup> queryGroupByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        List<SpecGroup> resultData = specGroupMapper.select(specGroup);
        if (resultData.isEmpty()) {
            throw new LyException(ExceptionEnum.SPEC_GROUP_NOT_FOUND);
        }
        return resultData;
    }

    public List<SpecParam> queryParamByGid(Long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        List<SpecParam> resultData = specParamMapper.select(specParam);
        if (resultData.isEmpty()) {
            throw new LyException(ExceptionEnum.SPEC_PARAM_NOT_FOUND);
        }
        return resultData;
    }
}
