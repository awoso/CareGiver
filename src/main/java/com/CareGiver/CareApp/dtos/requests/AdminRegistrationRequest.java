package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminRegistrationRequest {
    private String userName;
    private String email;
    private String password;
}
