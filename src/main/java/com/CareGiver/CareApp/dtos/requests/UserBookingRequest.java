package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserBookingRequest {
    private Long careGiverId;
    private Long userId;
    private String starTime;
    private String endTime;
}
