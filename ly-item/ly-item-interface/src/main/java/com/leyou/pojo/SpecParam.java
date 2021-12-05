package com.leyou.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/23
 */
@Data
@Table(name = "tb_spec_param")
public class SpecParam {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long cid;
    private Long groupId;
    private String name;
    @Column(name = "`numeric`")
    private Boolean numeric; // numeric 是 mysql 中的关键字 所以在表中加入了 `` 表示字符串
    private String unit;
    private Boolean generic;
    private Boolean searching;
    private String segments;
}
