package com.example.demo.converter;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {

    //Convert 1 đối tượng DTO sang Entity
    public CategoryEntity toEntity(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryDTO.getName());
//        categoryEntity.setEditDate(categoryDTO.getEditDate());
        categoryEntity.setDescription(categoryDTO.getDescription());
        return categoryEntity;
    }

    //Convert 1 đối tượng Entity sang DTO
    public CategoryDTO toDTO(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setCreateDate(categoryEntity.getCreateDate());
        categoryDTO.setEditDate(categoryEntity.getEditDate());
        categoryDTO.setDescription(categoryEntity.getDescription());
        return categoryDTO;
    }

    //Convert List đối tượng DTO sang Entity
    public List<CategoryDTO> toDTO(List<CategoryEntity> categoryEntities) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        if (categoryEntities.size() != 0) {
            for (int i = 0; i < categoryEntities.size(); i++) {
                categoryDTOS.add(toDTO(categoryEntities.get(i)));
            }
        }
        return categoryDTOS;
    }

    //Convert List đối tượng Entity sang DTO
    public List<CategoryEntity> toEntity(List<CategoryDTO> categoryDTOS) {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        if (categoryDTOS.size() != 0) {
            for (int i = 0; i < categoryDTOS.size(); i++) {
                categoryEntities.add(toEntity(categoryDTOS.get(i)));
            }
        }
        return categoryEntities;
    }

    //Convert DTO to entiy using old Entity
    public CategoryEntity toEntity(CategoryDTO categoryDTO, CategoryEntity categoryEntity) {
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setDescription(categoryDTO.getDescription());
        return categoryEntity;
    }
}
