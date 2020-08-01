package com.example.demo.repository;

import com.example.demo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    //    @Query(value = "SELECT * FROM new.product", nativeQuery = true)
//    List<ProductEntity> getAll();
    @Query(value = "SELECT * FROM new.category WHERE id = :id", nativeQuery = true)
    CategoryEntity getById(@Param("id") Integer id);

//    Optional<CategoryEntity> findById()
}
