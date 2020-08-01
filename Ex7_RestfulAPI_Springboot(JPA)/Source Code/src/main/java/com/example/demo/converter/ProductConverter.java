package com.example.demo.converter;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    //Convert 1 đối tượng DTO sang Entity
    public ProductEntity toEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setLinkImage(productDTO.getLinkImage());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setQuantity(productDTO.getQuantity());
        productEntity.setSoldQuanity(productDTO.getSoldQuanity());
        productEntity.setDescription(productDTO.getDescription());
//        productEntity.setCategoryId(productDTO.getCategoryId());
        return productEntity;
    }

    //Convert 1 đối tượng Entity sang DTO
    public ProductDTO toDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setLinkImage(productEntity.getLinkImage());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setQuantity(productEntity.getQuantity());
        productDTO.setSoldQuanity(productEntity.getSoldQuanity());
//        productDTO.setCategoryId(productEntity.getCategoryEntity());
        return productDTO;

    }

    //Conver DTO to Entity using old Entity
    public ProductEntity toEntity(ProductDTO productDTO, ProductEntity productEntity) {
        productEntity.setName(productDTO.getName());
        productEntity.setLinkImage(productDTO.getLinkImage());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setQuantity(productDTO.getQuantity());
        productEntity.setSoldQuanity(productDTO.getSoldQuanity());
        productEntity.setDescription(productDTO.getDescription());
        return productEntity;
    }

    //Convert List đối tượng DTO sang Entity
    public List<ProductDTO> toDTO(List<ProductEntity> productEntities) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        if (productEntities.size() != 0) {
            for (int i = 0; i < productEntities.size(); i++) {
                productDTOS.add(toDTO(productEntities.get(i)));
            }
        }
        return productDTOS;
    }

    //Convert List đối tượng Entity sang DTO
    public List<ProductEntity> toEntity(List<ProductDTO> productDTOS) {
        List<ProductEntity> productEntities = new ArrayList<>();
        if (productDTOS.size() != 0) {
            for (int i = 0; i < productDTOS.size(); i++) {
                productEntities.add(toEntity(productDTOS.get(i)));
            }
        }
        return productEntities;
    }
}
