package com.study.dao;

import com.study.entity.Article;
import com.study.entity.Tag;
import com.study.entity.User;
import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public List<Article> getAll() {
        ArrayList<Article> articles = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select a.oid,a.articleTitle,a.articleAbstract,a.articleCommentCount,a.articleViewCount,a.articleContent,a.articlePutTop,a.articleCreated,a.articleUpdated,a.articleRandomDouble,u.username from blogs_article a join blogs_user u on a.articleAuthorId=u.oid order by a.articleUpdated desc");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String articleTitle = resultSet.getString(2);
                String articleAbstract = resultSet.getString(3);
                Integer articleCommentCount = resultSet.getInt(4);
                Integer articleViewCount = resultSet.getInt(5);
                String articleContent = resultSet.getString(6);
                Integer articlePutTop = resultSet.getInt(7);
                Long articleCreated = resultSet.getLong(8);
                Long articleUpdated = resultSet.getLong(9);
                Integer articleRandomDouble = resultSet.getInt(10);
                String username = resultSet.getString(11);
                Article article = new Article(oId, articleTitle, articleAbstract, articleCommentCount, articleViewCount, articleContent, articlePutTop, articleCreated, articleUpdated, articleRandomDouble, new User(0, username));
                TagDAO tagDAO = new TagDAO();
                List<Tag> tags = tagDAO.getTagById(oId);
                article.setTags(tags);
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public List<Article> getHomeList() {
        ArrayList<Article> articles = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select a.oid,a.articleTitle,a.articleAbstract,a.articleCommentCount,a.articleViewCount,a.articleContent,a.articlePutTop,a.articleCreated,a.articleUpdated,a.articleRandomDouble,u.username from blogs_article a join blogs_user u on a.articleAuthorId=u.oid order by a.articlePutTop desc,a.articleUpdated desc limit 0,8");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String articleTitle = resultSet.getString(2);
                String articleAbstract = resultSet.getString(3);
                Integer articleCommentCount = resultSet.getInt(4);
                Integer articleViewCount = resultSet.getInt(5);
                String articleContent = resultSet.getString(6);
                Integer articlePutTop = resultSet.getInt(7);
                Long articleCreated = resultSet.getLong(8);
                Long articleUpdated = resultSet.getLong(9);
                Integer articleRandomDouble = resultSet.getInt(10);
                String username = resultSet.getString(11);
                Article article = new Article(oId, articleTitle, articleAbstract, articleCommentCount, articleViewCount, articleContent, articlePutTop, articleCreated, articleUpdated, articleRandomDouble, new User(0, username));
                TagDAO tagDAO = new TagDAO();
                List<Tag> tags = tagDAO.getTagById(oId);
                article.setTags(tags);
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public List<Article> getArticleByKeyWord(String keyWord) {
        ArrayList<Article> articles = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select a.oid,a.articleTitle,a.articleAbstract,a.articleCommentCount,a.articleViewCount,a.articleContent,a.articlePutTop,a.articleCreated,a.articleUpdated,a.articleRandomDouble,u.username from blogs_article a join blogs_user u on a.articleAuthorId=u.oid where a.articleTitle like ? order by a.articleUpdated desc");
            preparedStatement.setString(1, "%" + keyWord + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String articleTitle = resultSet.getString(2);
                String articleAbstract = resultSet.getString(3);
                Integer articleCommentCount = resultSet.getInt(4);
                Integer articleViewCount = resultSet.getInt(5);
                String articleContent = resultSet.getString(6);
                Integer articlePutTop = resultSet.getInt(7);
                Long articleCreated = resultSet.getLong(8);
                Long articleUpdated = resultSet.getLong(9);
                Integer articleRandomDouble = resultSet.getInt(10);
                String username = resultSet.getString(11);
                Article article = new Article(oId, articleTitle, articleAbstract, articleCommentCount, articleViewCount, articleContent, articlePutTop, articleCreated, articleUpdated, articleRandomDouble, new User(0, username));
                TagDAO tagDAO = new TagDAO();
                List<Tag> tags = tagDAO.getTagById(oId);
                article.setTags(tags);
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public Article getArticleById(Integer id) {
        Article article = null;
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select a.oid,a.articleTitle,a.articleAbstract,a.articleCommentCount,a.articleViewCount,a.articleContent,a.articlePutTop,a.articleCreated,a.articleUpdated,a.articleRandomDouble,u.username from blogs_article a join blogs_user u on a.articleAuthorId=u.oid where a.oid=? order by a.articleUpdated desc");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String articleTitle = resultSet.getString(2);
                String articleAbstract = resultSet.getString(3);
                Integer articleCommentCount = resultSet.getInt(4);
                Integer articleViewCount = resultSet.getInt(5);
                String articleContent = resultSet.getString(6);
                Integer articlePutTop = resultSet.getInt(7);
                Long articleCreated = resultSet.getLong(8);
                Long articleUpdated = resultSet.getLong(9);
                Integer articleRandomDouble = resultSet.getInt(10);
                String username = resultSet.getString(11);
                article = new Article(oId, articleTitle, articleAbstract, articleCommentCount, articleViewCount, articleContent, articlePutTop, articleCreated, articleUpdated, articleRandomDouble, new User(0, username));
                TagDAO tagDAO = new TagDAO();
                List<Tag> tags = tagDAO.getTagById(oId);
                article.setTags(tags);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    public List<Article> getNewList() {
        ArrayList<Article> articles = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select oid,articleTitle from blogs_article order by articleCreated desc limit 0,5");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String articleTitle = resultSet.getString(2);
                articles.add(new Article(oId, articleTitle));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public List<Article> getMaxCommentList() {
        ArrayList<Article> articles = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select oid,articleTitle from blogs_article order by articleCommentCount desc limit 0,5");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String articleTitle = resultSet.getString(2);
                articles.add(new Article(oId, articleTitle));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public List<Article> getVisitedList() {
        ArrayList<Article> articles = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select oid,articleTitle from blogs_article order by articleViewCount desc limit 0,5");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String articleTitle = resultSet.getString(2);
                articles.add(new Article(oId, articleTitle));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
}
