package com.tale.controller.api;


import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.ui.RestResponse;
import com.tale.model.dto.Types;
import com.tale.model.entity.Contents;
import com.tale.model.params.ArticleParam;
import com.tale.service.ContentsService;
import com.tale.service.SiteService;
import io.github.biezhi.anima.page.Page;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.tale.extension.Theme.intro;
import static com.tale.extension.Theme.show_thumb;

@Slf4j
@Path(value = "blog/api", restful = true)
public class IndexApiController  {

    @Inject
    private ContentsService contentsService;


    @Inject
    private SiteService siteService;

    @GetRoute("articles")
    public RestResponse articles(ArticleParam articleParam){
        articleParam.setType(Types.ARTICLE);
        articleParam.setOrderBy("created desc");
        Page<Contents> articles = contentsService.findArticles(articleParam,false);
        articles.getRows().forEach(article->{
            String content = article.getContent();
            if(StringUtil.isNullOrEmpty(article.getThumbImg())) {
                article.setThumbImg(show_thumb(article));
            }
            if(Objects.nonNull(content)){
                article.setContent(intro(content,75)+"……");
            }
        });
        return RestResponse.ok(articles);
    }
}
