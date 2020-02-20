package com.tale.controller.api;


import com.blade.ioc.annotation.Inject;
import com.blade.kit.JsonKit;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PathParam;
import com.blade.mvc.http.Response;
import com.blade.mvc.ui.RestResponse;
import com.tale.model.dto.PostDto;
import com.tale.model.dto.Types;
import com.tale.model.entity.Contents;
import com.tale.model.params.ArticleParam;
import com.tale.service.ContentsService;
import com.tale.service.SiteService;
import io.github.biezhi.anima.page.Page;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.tale.extension.Commons.site_url;
import static com.tale.extension.Theme.*;

@Slf4j
@Path(value = "open/api", restful = true)
public class IndexApiController  {

    @Inject
    private ContentsService contentsService;


    @Inject
    private SiteService siteService;

    @GetRoute("articles")
    public RestResponse articles(ArticleParam articleParam){
        articleParam.setType(Types.ARTICLE);
        articleParam.setOrderBy("created desc");
        articleParam.setStatus("publish");
        Page<Contents> articles = contentsService.findArticles(articleParam,false);
        Page<PostDto> post = articles.map(article->{
            String content = article.getContent();
            if(StringUtil.isNullOrEmpty(article.getThumbImg())) {
                article.setThumbImg(show_thumb(article));
            }
            if(Objects.nonNull(content)){
                article.setContent(intro(content,75)+"……");
            }
            String info = JsonKit.toString(article);
            PostDto postDto = JsonKit.formJson(info, PostDto.class);
            postDto.setIntro(article.getContent());
            postDto.setIcon(show_icon(article.getCid()));
            postDto.setUrl(permalink(article));
            return postDto;
        });
        return RestResponse.ok(post);
    }

    @GetRoute("article/info/:cid")
    public void articleInfo(@PathParam String cid, Response response) {
        Contents contents = contentsService.getContents(cid);
        contents.setContent("");
        response.json(contents);
    }

    @GetRoute("article/content/:cid")
    public void articleContent(@PathParam String cid, Response response) {
        Contents contents = contentsService.getContents(cid);
        response.text(contents.getContent());
    }
}
