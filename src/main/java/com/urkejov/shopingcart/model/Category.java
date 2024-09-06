package com.urkejov.shopingcart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Data

public class Category {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    private List<Product> productList;

}
