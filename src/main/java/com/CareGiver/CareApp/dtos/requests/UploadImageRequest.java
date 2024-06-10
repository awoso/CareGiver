package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class UploadImageRequest {
    private MultipartFile image;

}
