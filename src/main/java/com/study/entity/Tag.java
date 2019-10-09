package com.study.entity;

public class Tag {
    private Integer oId;
    private String tagTitle;
    private Integer tagPublishedRefCount;
    private Integer tagReferenceCount;

    public Tag(Integer oId, String tagTitle, Integer tagPublishedRefCount, Integer tagReferenceCount) {
        this.oId = oId;
        this.tagTitle = tagTitle;
        this.tagPublishedRefCount = tagPublishedRefCount;
        this.tagReferenceCount = tagReferenceCount;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public Integer getTagPublishedRefCount() {
        return tagPublishedRefCount;
    }

    public void setTagPublishedRefCount(Integer tagPublishedRefCount) {
        this.tagPublishedRefCount = tagPublishedRefCount;
    }

    public Integer getTagReferenceCount() {
        return tagReferenceCount;
    }

    public void setTagReferenceCount(Integer tagReferenceCount) {
        this.tagReferenceCount = tagReferenceCount;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "oId=" + oId +
                ", tagTitle='" + tagTitle + '\'' +
                ", tagPublishedRefCount=" + tagPublishedRefCount +
                ", tagReferenceCount=" + tagReferenceCount +
                '}';
    }
}
