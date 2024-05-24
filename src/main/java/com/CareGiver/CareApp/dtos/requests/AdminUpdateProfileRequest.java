package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminUpdateProfileRequest {
    private Long adminId;
    private String userName;
    private String email;
    private String password;
}
