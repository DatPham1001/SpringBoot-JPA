package com.example.demo.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDTO {
    private int id;
    private String name;
    private String linkImage;
    private BigDecimal price;
    private int quantity;
    private int soldQuanity;
    private String description;
    private int categoryId;


    //get set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//    public void setId(int id) { this.id = id; }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuanity() {
        return soldQuanity;
    }

    public void setSoldQuanity(int soldQuanity) {
        this.soldQuanity = soldQuanity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
