package com.example.demo.controller;


import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Get all products
    @GetMapping("/products")
    //Get all product with limit per page 5
    //http://localhost:8080/admin/products?page=1&limit=5
    public ResponseEntity<List<ProductDTO>> getAll(@RequestParam (name ="page") int page,
                                                   @RequestParam(name = "limit") int limit) {

        return ResponseEntity.ok(productService.getAll(page,limit));
    }

    //Get product with id
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    //Create new product
    @PostMapping("/product")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable int id) {
        productDTO.setId(id);
        return ResponseEntity.ok(productService.updateProduct(productDTO));
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "DELETED";
    }
}
