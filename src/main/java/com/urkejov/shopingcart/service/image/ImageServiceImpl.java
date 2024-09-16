package com.urkejov.shopingcart.service.image;

import com.urkejov.shopingcart.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public Image getImageById(String imageId) {
        return null;
    }

    @Override
    public void deleteImageById(String imageId) {

    }

    @Override
    public Image saveImage(MultipartFile file, String productId) {
        return null;
    }

    @Override
    public void updateImage(MultipartFile file, String imageId) {

    }
}
