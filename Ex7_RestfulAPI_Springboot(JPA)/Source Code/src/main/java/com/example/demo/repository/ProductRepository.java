package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    //Get all products
    @Query(value = "SELECT * FROM new.product LIMIT :page,:limit", nativeQuery = true)
    List<ProductEntity> getAll(@Param("page") int page,@Param("limit") int limit);

    //    ProductEntity getAll();
    //Get product by id
    @Query(value = "SELECT * FROM new.product WHERE id = :id", nativeQuery = true)
    ProductEntity getById(@Param("id") Integer id);

//    @Query(value = "DELETE FROM new.product WHERE id = :id;" ,nativeQuery = true)
//    ProductEntity deleteProduct(@Param("id") Integer id);

}
