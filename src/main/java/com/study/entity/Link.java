package com.study.entity;

public class Link {
    private String linkTitle;
    private String linkAddress;

    public Link(String linkTitle, String linkAddress) {
        this.linkTitle = linkTitle;
        this.linkAddress = linkAddress;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkTitle='" + linkTitle + '\'' +
                ", linkAddress='" + linkAddress + '\'' +
                '}';
    }
}
