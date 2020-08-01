package com.example.demo.service;

import com.example.demo.converter.CategoryConverter;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryDTO categoryDTO;
    private  final CategoryEntity categoryEntity;
    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;
    @Autowired
    public CategoryService(CategoryDTO categoryDTO, CategoryEntity categoryEntity, CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryDTO = categoryDTO;
        this.categoryEntity = categoryEntity;
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    //Get all categories
    public List<CategoryEntity> getAll() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryEntities;
    }

    //get one by id
    public CategoryDTO findByID(int id) {
        CategoryEntity categoryEntity = categoryRepository.getOne(id);
        CategoryDTO categoryDTO = categoryConverter.toDTO(categoryEntity);
        return categoryDTO;
    }

    //insert category
    public CategoryEntity createCategory(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryConverter.toEntity(categoryDTO);
        //Gett curtent time
        LocalDateTime dateTime = LocalDateTime.now();
        categoryEntity.setCreateDate(dateTime);
        categoryEntity.setEditDate(dateTime);
        //Set curtime to edit and create the same
        categoryRepository.save(categoryEntity);
        return categoryEntity;
    }

    //update
    public CategoryEntity updateCategory(CategoryDTO categoryDTO) {
        //Get category in data which user want to edit
        CategoryEntity oldCategory = categoryRepository.getById(categoryDTO.getId());
        //Convert from DTO to Entity
        CategoryEntity categoryEntity = categoryConverter.toEntity(categoryDTO, oldCategory);
        //Get curtime set to Edit date if this func called
        LocalDateTime localDateTime = LocalDateTime.now();
        categoryEntity.setEditDate(localDateTime);
        //Save new info of Entity
        categoryRepository.save(categoryEntity);
        return categoryEntity;
    }

    @Transactional(rollbackFor = Exception.class)
    public String deleteCategory(int id) throws Exception {
        CategoryEntity categoryEntity = categoryRepository.getById(id);
        if (categoryEntity != null) {
            categoryRepository.delete(categoryEntity);
            return "DELETED";
        } else return "No Category Found";
    }
}

