package com.example.demo.controller;


import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryEntity>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> findByID(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.findByID(id));
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryEntity> save(@RequestBody CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(categoryEntity);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable int id, @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setId(id);
        CategoryEntity categoryEntity = categoryService.updateCategory(categoryDTO);
        return ResponseEntity.ok(categoryEntity);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) throws Exception {

        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}
