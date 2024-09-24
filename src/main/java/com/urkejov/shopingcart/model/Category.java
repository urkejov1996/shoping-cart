package com.urkejov.shopingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Category(String name) {

    }

    @PrePersist
    private void prePersist() {
        LocalDateTime date = LocalDateTime.now();
        this.createdAt = date;
        this.updatedAt = date;
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
