package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CareGiverUpdateProfileRequest {
    private Long careGiverId;
    private String userName;
    private String email;
    private String password;
    private String servicesOffered;
    private String qualification;
    private String yearsOfExperience;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
