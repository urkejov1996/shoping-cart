package com.urkejov.shopingcart.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Blob;

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
}
