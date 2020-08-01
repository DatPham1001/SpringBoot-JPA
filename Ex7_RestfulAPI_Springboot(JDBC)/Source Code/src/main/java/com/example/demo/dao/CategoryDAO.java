package com.example.demo.dao;

import com.example.demo.connector.Connector;
import com.example.demo.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class CategoryDAO {
    @Autowired
    CategoryDTO categoryDTO;
    @Autowired
    Connector connector ;
    Connection connection = connector.getConnection();


    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        String sql = "INSERT INTO `sapo`.`category` (`category_name`, `ngay_sua`, `mo_ta`) " +
                "VALUES (?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryDTO.getName());
            preparedStatement.setString(2, categoryDTO.getNgaySua());
            preparedStatement.setString(3, categoryDTO.getDescription());
            preparedStatement.execute(sql);
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return categoryDTO;
    }

    public ResponseEntity<?> getAllCategory(int pageNumber) throws SQLException {
        ArrayList<CategoryDTO> categories = new ArrayList<>();
        String sql = "SELECT category_name,ngay_tao,ngay_sua,mo_ta\n" +
                " FROM category\n" +
                " LIMIT " + pageNumber * 2 + ",2";
        ResultSet resultSet = connector.executePreparedStatement(sql);
        while (resultSet.next()) {
            String name = resultSet.getString("category_name");
            String ngayTao = resultSet.getString("ngay_tao");
            String ngaySua = resultSet.getString("ngay_sua");
            String moTa = resultSet.getString("mo_ta");
            categories.add(new CategoryDTO(name, ngayTao, ngaySua, moTa));
        }

        //Test MApper failed ( khi gọi bị ghi đè,nếu)
//        categoryMapper.getFromResultSet(sql);
//        categories.add(new CategoryDTO(categoryMapper));
        return ResponseEntity.ok(categories);
    }

    public ResponseEntity<CategoryDTO> getCategoryByID(int id) throws SQLException {
        String sql = "SELECT category_name,ngay_tao,ngay_sua,mo_ta\n" +
                " FROM category\n" +
                " WHERE category_id =" + id;
        ResultSet resultSet = connector.executePreparedStatement(sql);
        while (resultSet.next()) {
            categoryDTO.setName(resultSet.getString("category_name"));
            categoryDTO.setNgaySua(resultSet.getString("ngay_sua"));
            categoryDTO.setNgayTao(resultSet.getString("ngay_tao"));
            categoryDTO.setDescription(resultSet.getString("mo_ta"));
        }
        return ResponseEntity.ok(categoryDTO);
    }

    public ResponseEntity updateCategory(int id, CategoryDTO categoryDTO) {
//        String sql = "UPDATE `sapo`.`category` " +
//                "SET `category_name` = ?, `ngay_sua` = ?, `mo_ta` = ? " +
//                "WHERE (`category_id` = ?);";
        String sql = "UPDATE `sapo`.`category` " +
                "SET `category_name` ='" + categoryDTO.getName() + "', `ngay_sua` ='" + categoryDTO.getNgaySua() + "', `mo_ta` ='" + categoryDTO.getDescription() + "' " +
                "WHERE (`category_id` = '" + id + "');";
        Statement statement = connector.updateQuery(sql);
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, categoryDTO.getName());
//            preparedStatement.setString(2, categoryDTO.getNgaySua());
//            preparedStatement.setString(3, categoryDTO.getDescription());
//            preparedStatement.setInt(4, id);
//            preparedStatement.execute(sql);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return ResponseEntity.ok(categoryDTO);
    }

    public ResponseEntity deleteCategory(int id) {
//        String sql1 = "START TRANSACTION;";
//         String sql2 = "DELETE FROM product" +
//                        "Where category_id = 2;";
//        Statement statement = connector.updateQuery(sql1);
//        Statement statement1 = connector.updateQuery(sql2);
        return ResponseEntity.ok(200);
    }


}
