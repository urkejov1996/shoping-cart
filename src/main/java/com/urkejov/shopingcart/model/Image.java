package com.urkejov.shopingcart.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "fileType")
    private String fileType;

    @Lob
    @Column(name = "image")
    private Blob image;

    @Column(name = "download_url")
    private String downloadUrl;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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
