package com.example.demo.controller;


import com.example.demo.dao.ProductDAO;
import com.example.demo.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/admin")
public class ProductController {
    ProductDAO productDAO = new ProductDAO();

    //    @RequestBody ProductDTO productDTO
    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO result = productDAO.createProduct(productDTO);
        return result;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductByID(@PathVariable int id) throws SQLException {
        ResponseEntity result = productDAO.getProductByID(id);
        return result;
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        ResponseEntity result = productDAO.updateProduct(id, productDTO);
        return result;
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        ResponseEntity result = productDAO.deleteProduct(id);
        return result;
    }

    //Get all product phan trang
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getAllProduct(@PathVariable int id) throws SQLException {
        ResponseEntity result = productDAO.getAllProduct(id);
        return ResponseEntity.ok(result);
    }
}
