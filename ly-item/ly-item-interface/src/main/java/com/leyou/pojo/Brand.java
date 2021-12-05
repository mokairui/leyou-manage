package com.leyou.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_brand")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 属性格式不可以设置基本类型int, long等, 要使用Integer, Long等包装类,
    // 使用基本类型通用mapper查询出来的id都是0
    private Long id;
    private String name;
    private String image;
    private String letter;

}
