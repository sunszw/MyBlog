package com.study.web;

import com.study.dao.ArticleDAO;
import com.study.entity.Article;
import com.study.utils.ThyUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDAO articleDAO = new ArticleDAO();
        List<Article> articles = articleDAO.getAll();

        Context context = new Context();
        context.setVariable("articles", articles);

        ThyUtils.print("list", resp, context);

    }
}
