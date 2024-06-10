package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.dtos.requests.UploadImageRequest;
import com.CareGiver.CareApp.dtos.responses.UploadImageResponse;

import java.io.IOException;

public interface CloudinaryImageService {
    UploadImageResponse uploadImage(UploadImageRequest request) throws IOException;

}
