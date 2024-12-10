package com.rateMovie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @Column(name = "category_id")
    private Long id;
    @Column(nullable = false)
    private String category_name;

    public Category() {
    }

    public Category(String category_name, Long id) {
        this.category_name = category_name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
