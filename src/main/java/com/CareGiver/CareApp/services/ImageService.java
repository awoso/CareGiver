package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.Image;
import com.CareGiver.CareApp.dtos.responses.UploadImageResponse;

public interface ImageService {
    Image saveImage(UploadImageResponse response);
}
