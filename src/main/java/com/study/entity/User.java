package com.study.entity;

public class User {
    private Integer oId;
    private String username;

    public User(Integer oId, String username) {
        this.oId = oId;
        this.username = username;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "oId=" + oId +
                ", username='" + username + '\'' +
                '}';
    }
}
