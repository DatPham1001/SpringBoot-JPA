package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductDTO {
    private int id;


    private String name;
    private String link;
    private long price;
    private int quantity;
    private int soldQuantity;
    private String description;
    private int categoryID;
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductDTO() {
    }

    //Contructor
    public ProductDTO(String name, String link, long price, int quantity, int soldQuantity, String description, String categoryName) {
        this.name = name;
        this.link = link;
        this.price = price;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
        this.description = description;
        this.categoryName = categoryName;
    }
//Getter Setter

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}

