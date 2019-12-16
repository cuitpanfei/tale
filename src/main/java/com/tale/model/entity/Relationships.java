package com.tale.model.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据关系
 *
 * @author biezhi
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "t_relationships", pk = "mid")
public class Relationships extends Model {

    /**
     * 文章主键
     */
    private Integer cid;

    /**
     * 项目主键
     */
    private Integer mid;

}