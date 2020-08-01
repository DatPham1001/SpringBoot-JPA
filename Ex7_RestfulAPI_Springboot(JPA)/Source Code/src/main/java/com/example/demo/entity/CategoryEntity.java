package com.example.demo.entity;


import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    @NonNull
    @Column
    private LocalDateTime createDate;
    @NonNull
    @Column
    private LocalDateTime editDate;
    @NonNull
    @Column
    private String description;


    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.REMOVE)
    private final List<ProductEntity> productEntity = new ArrayList<>();

    //Get set
    @NonNull
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(@NonNull LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @NonNull
    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(@NonNull LocalDateTime editDate) {
        this.editDate = editDate;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}
