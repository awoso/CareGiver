package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CareGiverUploadProfilePictureRequest {
    private Long careGiverId;
    private UploadImageRequest uploadImageRequest;

}
