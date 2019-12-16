package com.tale.model.dto;

import java.util.Date;
import java.util.List;

import com.tale.model.entity.Contents;

import io.github.biezhi.anima.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章归档
 * <p>
 * Created by biezhi on 2017/2/23.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Archive extends Model {

    private String         dateStr;
    private Date           date;
    private String         count;
    private List<Contents> articles;

}
