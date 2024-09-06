package com.urkejov.shopingcart.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor

public class Product {

    private String id;
    private String name;
    private String brand;

    private BigDecimal price;
    private int inventory;
    private String description;


    private Category category;
    private List<Image> images;


}
