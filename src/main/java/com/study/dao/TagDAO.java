package com.study.dao;

import com.study.entity.Tag;
import com.study.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagDAO {
    public List<Tag> getTags() {
        ArrayList<Tag> tags = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select oid,tagTitle,tagReferenceCount from blogs_tag order by tagReferenceCount desc limit 0,5");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String tagTitle = resultSet.getString(2);
                Integer tagReferenceCount = resultSet.getInt(3);
                tags.add(new Tag(oId, tagTitle, 0, tagReferenceCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }

    public List<Tag> getTagById(Integer articleId) {
        ArrayList<Tag> tags = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select t.oid,t.tagtitle from blogs_tag_article ta join blogs_tag t on ta.tag_oid=t.oid where article_oid=?");
            preparedStatement.setInt(1,articleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer oId = resultSet.getInt(1);
                String tagTitle = resultSet.getString(2);
                tags.add(new Tag(oId, tagTitle, 0, 0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }
}
