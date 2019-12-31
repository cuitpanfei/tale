package com.tale.model.dto;

import io.github.biezhi.anima.annotation.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    /**
     * 文章表主键
     */
    private Integer cid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章缩略名
     */
    private String slug;

    /**
     * 文章创建时间戳
     */
    private Integer created;

    /**
     * 文章修改时间戳
     */
    private Integer modified;

    /**
     * 文章摘要
     */
    private String intro;

    /**
     * 文章创建用户
     */
    private String author;

    /**
     * 文章点击次数
     */
    private Integer hits;


    /**
     * 文章缩略图
     */
    private String thumbImg;

    /**
     * 标签列表
     */
    private String tags;

    /**
     * 分类列表
     */
    private String categories;

    /**
     * 内容所属评论数
     */
    private Integer commentsNum;

    /**
     * 是否允许评论
     */
    private Boolean allowComment;

    /**
     * 是否允许ping
     */
    private Boolean allowPing;

    /**
     * 允许出现在Feed中
     */
    private Boolean allowFeed;

    /**
     * 文章地址
     */
    private String url;
    /**
     * 文章随即icon
     */
    private String icon;
}
