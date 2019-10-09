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

public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ArticleDAO articleDAO = new ArticleDAO();
        Article article = articleDAO.getArticleById(Integer.parseInt(id));

        Context context = new Context();
        context.setVariable("article", article);

        ThyUtils.print("article", resp, context);
    }
}
