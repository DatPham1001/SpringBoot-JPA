package com.example.demo.service;

import com.example.demo.converter.ProductConverter;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final CategoryRepository categoryRepository;
    @Autowired
    public ProductService(ProductRepository productRepository, ProductConverter productConverter, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
        this.categoryRepository = categoryRepository;
    }

    //get all products
    public List<ProductDTO> getAll(int page,int limit) {
//        List<ProductDTO> productDTO = new ArrayList<>();
//        List<ProductEntity> productEntities = new ArrayList<>();
        //get List of products from database (Entity)
        List<ProductEntity> productEntities = productRepository.getAll(page,limit);
        //Convert List of products to DTO
        List<ProductDTO> productDTO = productConverter.toDTO(productEntities);
        return productDTO;
    }

    //get product by id
    public ProductDTO getById(int id) {
        //Get single product from Entity and Convert to DTO
        ProductEntity productEntity = productRepository.getById(id);
        ProductDTO productDTO = productConverter.toDTO(productEntity);
        return productDTO;
    }

    //Create new product
    public ProductEntity createProduct(ProductDTO productDTO) {
        //get categoryEntity from id in DTO because categoryID is foreign key
        CategoryEntity categoryEntity = categoryRepository.getOne(productDTO.getCategoryId());
//        ProductEntity productEntity = productRepository.createProduct(productDTO.getName(), productDTO.getDescription(), productDTO.getLinkImage(), productDTO.getPrice(), productDTO.getQuantity(), productDTO.getSoldQuanity(), productDTO.getCategoryId());
        //Convert to Entity to save
        ProductEntity productEntity = productConverter.toEntity(productDTO);
        //set foreign key categoryEntity
        productEntity.setCategoryEntity(categoryEntity);
        productRepository.save(productEntity);
        return productEntity;

    }

    public ProductEntity updateProduct(ProductDTO productDTO) {

        //Ý tưởng là update thì lấy Entity có sẵn trong data theo id Pathvariable request,rồi set giá trị từ DTO
        //xong rồi dùng hàm save() có sẵn JPA

        //get old product from data use ID provided in URL PathVariable
        ProductEntity oldProduct = productRepository.getById(productDTO.getId());
        //convert oldProductEntity with new value from DTO to new ProductEntity
        ProductEntity productEntity = productConverter.toEntity(productDTO, oldProduct);
        //get categoryID provided by DTO and set to foreign key
        CategoryEntity categoryEntity = categoryRepository.getOne(productDTO.getCategoryId());
        productEntity.setCategoryEntity(categoryEntity);
        //save new product (with Foreign key not null => update new product)
        productRepository.save(productEntity);
        return productEntity;
    }

    public ProductEntity deleteProduct(int id) {
        ProductEntity productEntity = productRepository.getById(id);
        productRepository.delete(productEntity);
        return productEntity;
    }
}


