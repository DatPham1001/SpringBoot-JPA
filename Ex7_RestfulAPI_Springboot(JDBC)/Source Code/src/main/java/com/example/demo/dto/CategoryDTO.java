package com.example.demo.dto;

import com.example.demo.Mapper.CategoryMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTO {
    private int id;
    private String name;
    private String ngayTao;
    private String ngaySua;
    private String description;

    public CategoryDTO(String name, String ngayTao, String ngaySua, String description) {
        this.name = name;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.description = description;
    }

    public CategoryDTO() {
    }

    public CategoryDTO(CategoryMapper categoryMapper) {
    }

    //Getter Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
