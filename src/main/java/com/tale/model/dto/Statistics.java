package com.tale.model.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 后台统计对象
 * <p>
 * Created by biezhi on 2017/2/24.
 */
@Data
public class Statistics implements Serializable {

    private static final long serialVersionUID = 2329863829741481287L;
	// 文章数
    private long articles;
    // 页面数
    private long pages;
    // 评论数
    private long comments;
    // 分类数
    private long categories;
    // 标签数
    private long tags;
    // 附件数
    private long attachs;

}
