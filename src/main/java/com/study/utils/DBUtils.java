package com.study.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static DruidDataSource druidDataSource;

    static {
        try (InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            druidDataSource = new DruidDataSource();
            druidDataSource.setUrl(properties.getProperty("jdbcUrl"));
            druidDataSource.setDriverClassName(properties.getProperty("driverClassName"));
            druidDataSource.setUsername(properties.getProperty("username"));
            druidDataSource.setPassword(properties.getProperty("password"));
            druidDataSource.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));
            druidDataSource.setMinIdle(Integer.parseInt(properties.getProperty("minIdle")));
            druidDataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
            druidDataSource.setMaxWait(Long.parseLong(properties.getProperty("maxWait")));
            druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(properties.getProperty("timeBetweenEvictionRunsMillis")));
            druidDataSource.setMinEvictableIdleTimeMillis(Long.parseLong(properties.getProperty("minEvictableIdleTimeMillis")));
            druidDataSource.setValidationQuery(properties.getProperty("validationQuery"));
            druidDataSource.setTestOnBorrow(Boolean.parseBoolean(properties.getProperty("testOnBorrow")));
            druidDataSource.setTestOnReturn(Boolean.parseBoolean(properties.getProperty("testOnReturn")));
            druidDataSource.setTestWhileIdle(Boolean.parseBoolean(properties.getProperty("testWhileIdle")));
            druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(properties.getProperty("poolPreparedStatements")));
            druidDataSource.setMaxOpenPreparedStatements(Integer.parseInt(properties.getProperty("maxOpenPreparedStatements")));
            druidDataSource.setAsyncInit(Boolean.parseBoolean(properties.getProperty("asyncInit")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return druidDataSource.getConnection();
    }
}
