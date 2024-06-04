package com.CareGiver.CareApp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserBookingResponse {
    private String message;
    private Long bookingId;
}
