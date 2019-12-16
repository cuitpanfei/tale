package com.tale.model.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by biezhi on 2017/3/15.
 */
@Data
public class ThemeDto implements Serializable {

    private static final long serialVersionUID = 7122701941161403708L;

	/**
     * 主题名称
     */
    private String name;

    /**
     * 是否有设置项
     */
    private boolean hasSetting;

    public ThemeDto(String name) {
        this.name = name;
    }

}
