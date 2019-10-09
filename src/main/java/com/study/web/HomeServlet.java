package com.study.web;

import com.study.dao.ArticleDAO;
import com.study.dao.LinkDAO;
import com.study.dao.TagDAO;
import com.study.entity.Article;
import com.study.utils.ThyUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDAO articleDAO = new ArticleDAO();
        TagDAO tagDAO = new TagDAO();
        LinkDAO linkDAO = new LinkDAO();
        Context context = new Context();

        //传递文章
        List<Article> articles = articleDAO.getHomeList();
        //第1篇
        context.setVariable("first", articles.get(0));
        //第2-4篇
        context.setVariable("second", articles.subList(1, 4));
        //第5-8篇
        context.setVariable("third", articles.subList(5, articles.size()));

        //查询最新文章列表
        context.setVariable("newList", articleDAO.getNewList());
        //查询最多评论数量文章列表
        context.setVariable("maxCommentList", articleDAO.getMaxCommentList());
        //查询最多访问数量文章列表
        context.setVariable("visitedList", articleDAO.getVisitedList());

        //传递标签
        context.setVariable("tags", tagDAO.getTags());

        //查询所有链接
        context.setVariable("links", linkDAO.getLinks());

        //返回视图数据
        ThyUtils.print("index", resp, context);

    }
}
