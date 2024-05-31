package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CareGiverRegistrationRequest {
    private String userName;
    private String email;
    private String password;
    private String servicesOffered;
    private String qualification;
    private int yearsOfExperience;
}
