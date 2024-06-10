package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WelcomeMessageWelcomeRequest {

    private String name;
    private String email;
}
