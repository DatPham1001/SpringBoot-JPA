package com.example.demo.entity;


import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Component
@Table(name = "product")
public class ProductEntity extends BaseEntity {


    @Column
    @NotNull
    private String linkImage;

    @Column
    @NonNull
    private BigDecimal price;

    @Column
    @NonNull
    private int quantity;

    @Column
    @NonNull
    private int soldQuanity;

    @Column
    @NonNull
    private String description;

//    @Column
//    private int categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    public ProductEntity() {
    }

    //get set

//    public int getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(int categoryId) {
//        this.categoryId = categoryId;
//    }

    @NonNull
    public String getLinkImage() {
        return linkImage;
    }

    @NonNull
    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSoldQuanity() {
        return soldQuanity;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setLinkImage(@NonNull String linkImage) {
        this.linkImage = linkImage;
    }

    public void setPrice(@NonNull BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSoldQuanity(int soldQuanity) {
        this.soldQuanity = soldQuanity;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
