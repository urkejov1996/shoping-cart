package com.urkejov.shopingcart.service.image;

import com.urkejov.shopingcart.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image getImageById(String imageId);

    void deleteImageById(String imageId);

    Image saveImage(MultipartFile file, String productId);

    void updateImage(MultipartFile file, String imageId);
}
