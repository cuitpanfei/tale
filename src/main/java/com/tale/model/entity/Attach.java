package com.tale.model.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 附件
 * <p>
 * Created by biezhi on 2017/2/23.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "t_attach")
public class Attach extends Model {

    private Integer id;
    private String  fname;
    private String  ftype;
    private String  fkey;
    private Integer authorId;
    private Integer created;

}
