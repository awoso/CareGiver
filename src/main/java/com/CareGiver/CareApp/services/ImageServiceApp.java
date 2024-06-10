package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.Image;
import com.CareGiver.CareApp.data.repositories.ImageRepository;
import com.CareGiver.CareApp.dtos.responses.UploadImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceApp implements ImageService{

    private final ImageRepository imageRepository;
    @Override
    public Image saveImage(UploadImageResponse response) {
        Image image = new Image();
        image.setImageUrl(response.getUrl());
        imageRepository.save(image);
        return image;
    }
}
