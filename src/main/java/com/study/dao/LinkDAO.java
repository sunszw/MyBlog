package com.study.dao;

import com.study.entity.Link;
import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinkDAO {
    public List<Link> getLinks() {
        ArrayList<Link> links = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select linktitle,linkaddress from blogs_link");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String linkTitle = resultSet.getString(1);
                String linkAddress = resultSet.getString(2);
                links.add(new Link(linkTitle, linkAddress));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return links;
    }
}
