package com.urkejov.shopingcart.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.sql.Blob;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Image {

    private String id;
    private String fileName;
    private String fileType;

    private Blob image;
    private String downloadUrl;

    private Product product;
}
