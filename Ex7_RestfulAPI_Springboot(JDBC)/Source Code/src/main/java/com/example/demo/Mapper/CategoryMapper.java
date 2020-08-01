package com.example.demo.Mapper;

import com.example.demo.connector.Connector;
import com.example.demo.dto.CategoryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper {
    Connector connector = new Connector();
    Connection connection = connector.getConnection();

    public CategoryDTO getFromResultSet(String sql) {
        CategoryDTO categoryDTO = new CategoryDTO();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                categoryDTO.setName(resultSet.getString("category_name"));
                categoryDTO.setNgayTao(resultSet.getString("ngay_tao"));
                categoryDTO.setNgaySua(resultSet.getString("ngay_sua"));
                categoryDTO.setDescription(resultSet.getString("mo_ta"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryDTO;
    }
}