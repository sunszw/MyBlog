package com.study.entity;

import java.util.List;

public class Article {
    private Integer oId;
    private String articleTitle;
    private String articleAbstract;
    private Integer articleCommentCount;
    private Integer articleViewCount;
    private String articleContent;
    private Integer articlePutTop;
    private Long articleCreated;
    private Long articleUpdated;
    private Integer articleRandomDouble;
    private User user;
    private List<Tag> tags;
    private String createdTime;

    public Article(Integer oId, String articleTitle, String articleAbstract, Integer articleCommentCount, Integer articleViewCount, String articleContent, Integer articlePutTop, Long articleCreated, Long articleUpdated, Integer articleRandomDouble, User user) {
        this.oId = oId;
        this.articleTitle = articleTitle;
        this.articleAbstract = articleAbstract;
        this.articleCommentCount = articleCommentCount;
        this.articleViewCount = articleViewCount;
        this.articleContent = articleContent;
        this.articlePutTop = articlePutTop;
        this.articleCreated = articleCreated;
        this.articleUpdated = articleUpdated;
        this.articleRandomDouble = articleRandomDouble;
        this.user = user;
    }

    public Article(Integer oId, String articleTitle) {
        this.oId = oId;
        this.articleTitle = articleTitle;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Integer getArticleViewCount() {
        return articleViewCount;
    }

    public void setArticleViewCount(Integer articleViewCount) {
        this.articleViewCount = articleViewCount;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArticlePutTop() {
        return articlePutTop;
    }

    public void setArticlePutTop(Integer articlePutTop) {
        this.articlePutTop = articlePutTop;
    }

    public Long getArticleCreated() {
        return articleCreated;
    }

    public void setArticleCreated(Long articleCreated) {
        this.articleCreated = articleCreated;
    }

    public Long getArticleUpdated() {
        return articleUpdated;
    }

    public void setArticleUpdated(Long articleUpdated) {
        this.articleUpdated = articleUpdated;
    }

    public Integer getArticleRandomDouble() {
        return articleRandomDouble;
    }

    public void setArticleRandomDouble(Integer articleRandomDouble) {
        this.articleRandomDouble = articleRandomDouble;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "oId=" + oId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                ", articleCommentCount=" + articleCommentCount +
                ", articleViewCount=" + articleViewCount +
                ", articleContent='" + articleContent + '\'' +
                ", articlePutTop=" + articlePutTop +
                ", articleCreated=" + articleCreated +
                ", articleUpdated=" + articleUpdated +
                ", articleRandomDouble=" + articleRandomDouble +
                ", user=" + user +
                ", tags=" + tags +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}
