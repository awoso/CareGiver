package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.dtos.requests.UploadImageRequest;
import com.CareGiver.CareApp.dtos.responses.UploadImageResponse;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class CloudinaryImageServiceApp implements CloudinaryImageService{

    private final Cloudinary cloudinary;
    @Override
    public UploadImageResponse uploadImage(UploadImageRequest request) throws IOException {
        UploadImageResponse response = new UploadImageResponse();
        Map uploadedResult = cloudinary.uploader().upload(request.getImage().getBytes(), ObjectUtils.emptyMap());
        String url = uploadedResult.get("url").toString();
        response.setUrl(url);
        return response;
    }
}
