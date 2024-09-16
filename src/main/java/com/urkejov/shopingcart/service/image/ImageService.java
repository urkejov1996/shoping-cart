package com.urkejov.shopingcart.service.image;

import com.urkejov.shopingcart.dto.ImageDto;
import com.urkejov.shopingcart.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    Image getImageById(String imageId);

    void deleteImageById(String imageId);

    List<ImageDto> saveImages(List<MultipartFile> files, String productId);

    void updateImage(MultipartFile file, String imageId);
}
