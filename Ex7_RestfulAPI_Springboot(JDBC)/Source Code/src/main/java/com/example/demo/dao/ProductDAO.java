package com.example.demo.dao;


import com.example.demo.connector.Connector;
import com.example.demo.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class ProductDAO {
    //    private ApplicationContext context;
//    ProductDTO productDTO = context.getBean(ProductDTO.class);
//    Connector connector = context.getBean(Connector.class);
    @Autowired
    ProductDTO productDTO ;
    @Autowired
    Connector connector;
    Connection connection = connector.getConnection();

    //Create New product
    public ProductDTO createProduct(ProductDTO productDTO) {
        //Get value through DTO
        int id = productDTO.getId();
        int categoryID = productDTO.getCategoryID();
        String name = productDTO.getName();
        String link = productDTO.getLink();
        long price = productDTO.getPrice();
        int quantity = productDTO.getQuantity();
        int soldQuantity = productDTO.getSoldQuantity();
        String description = productDTO.getDescription();
        //Execute Query to database
        String sql =
                "INSERT INTO `sapo`.`product`(`category_id`, `product_name`, `link`, `price`, `quantity`, `sold_quantity`, `product_decription`) " +
                        "VALUES ('" + categoryID + "', '" + name + "', '" + link + "', '" + price + "', '" + quantity + "', '" + soldQuantity + "', '" + description + "');";
        Statement statement = connector.updateQuery(sql);
        return productDTO;
    }

    //Get prodcut info by ID
    public ResponseEntity<ProductDTO> getProductByID(int id) throws SQLException {
        String sql =
                "SELECT product_id,product_name,link,price,quantity,sold_quantity,product_decription,category_name as category" +
                        " FROM product INNER JOIN category ON product.category_id = category.category_id" +
                        " WHERE product_id = " + id + ";";

        ResultSet resultSet = connector.executePreparedStatement(sql);
        while (resultSet.next()) {
            productDTO.setId(resultSet.getInt("product_id"));
            productDTO.setName(resultSet.getString("product_name"));
            productDTO.setLink(resultSet.getString("link"));
            productDTO.setPrice(resultSet.getLong("price"));
            productDTO.setQuantity(resultSet.getInt("quantity"));
            productDTO.setSoldQuantity(resultSet.getInt("sold_quantity"));
            productDTO.setDescription(resultSet.getString("product_decription"));
            productDTO.setCategoryName(resultSet.getString("category"));
        }
        return ResponseEntity.ok(productDTO);
    }

    //Update a product by ID
    public ResponseEntity updateProduct(int id, ProductDTO productDTO) {
        String sql = "UPDATE `sapo`.`product` \n" +
                "SET `product_name` = '" + productDTO.getName() + "', \n" +
                "`link` = '" + productDTO.getLink() + "', \n" +
                "`price` = '" + productDTO.getPrice() + "',\n" +
                "`quantity` = '" + productDTO.getQuantity() + "', \n" +
                "`sold_quantity` = '" + productDTO.getSoldQuantity() + "',\n" +
                " `product_decription` = '" + productDTO.getDescription() + "' \n" +
                " WHERE (`product_id` = '" + id + "');";
        Statement statement = connector.updateQuery(sql);
        return ResponseEntity.ok(200);
    }

    //DElete product
    public ResponseEntity deleteProduct(int id) {
        String sql = "DELETE FROM `sapo`.`product` " +
                "WHERE (`product_id` = '" + id + "');";
        Statement statement = connector.updateQuery(sql);
        return ResponseEntity.ok(200);
    }

    //Get all Product
//    public ProductDTO getAllProduct(int pageNumber){
    public ResponseEntity getAllProduct(int pageNumber) throws SQLException {
        ArrayList<ProductDTO> products = new ArrayList<>();
        String sql = "SELECT product_name,link,price,quantity,sold_quantity,product_decription,category_name\n" +
                "FROM product left join category on category.category_id = product.category_id\n" +
                "LIMIT " + pageNumber * 10 + ",10";
        ResultSet resultSet = connector.executePreparedStatement(sql);
        while (resultSet.next()) {
            String product_name = resultSet.getString("product_name");
            String link = resultSet.getString("link");
            int price = resultSet.getInt("price");
            int quantity = resultSet.getInt("quantity");
            int sold = resultSet.getInt("sold_quantity");
            String description = resultSet.getString("product_decription");
            String categoryName = resultSet.getString("category_name");
            products.add(new ProductDTO(product_name, link, price, quantity, sold, description, categoryName));
        }

        return ResponseEntity.ok(products);
    }

}
