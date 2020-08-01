package com.example.demo.connector;

import org.springframework.stereotype.Component;

import java.sql.*;


@Component
public class Connector {
    Connection connection = null;
    //Khai bao thong tin database
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/sapo";
    static final String USER = "root";
    static final String PASS = "1234";


    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connect database successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("connect database faied classNotFound!");
        } catch (SQLException throwables) {
            System.out.println("connect database faied SQLEx!");
        }

        return connection;
    }

    public ResultSet executePreparedStatement(String sql) {
//        PreparedStatement preparedStatement = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            return resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Statement updateQuery(String sql) {
        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
