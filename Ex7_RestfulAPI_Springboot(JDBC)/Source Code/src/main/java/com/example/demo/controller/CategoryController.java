package com.example.demo.controller;


import com.example.demo.dao.CategoryDAO;
import com.example.demo.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/admin")
public class CategoryController {
    CategoryDAO categoryDAO = new CategoryDAO();

    @PostMapping("/category")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryDAO.createCategory(categoryDTO);
    }

    //Get all category
    @GetMapping("/categories/{id}")
    public ResponseEntity getAllCategory(@PathVariable int id) throws SQLException {
        return ResponseEntity.ok(categoryDAO.getAllCategory(id));
    }

    //Get by ID
    @GetMapping("/category/{id}")
    public ResponseEntity getByID(@PathVariable int id) throws SQLException {
        return ResponseEntity.ok(categoryDAO.getCategoryByID(id));
    }

    @PutMapping("/category/{id}")
    public ResponseEntity updateCategory(@PathVariable int id, @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryDAO.updateCategory(id, categoryDTO));
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id) {

        return ResponseEntity.ok(categoryDAO.deleteCategory(id));
    }


}
