package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationRequest {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}
