package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminLoginRequest {
    private String email;
    private String password;
}
