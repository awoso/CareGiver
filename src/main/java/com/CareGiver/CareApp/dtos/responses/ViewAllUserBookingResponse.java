package com.CareGiver.CareApp.dtos.responses;

import com.CareGiver.CareApp.data.models.Booking;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewAllUserBookingResponse {
    List<Booking> UserBookings;
}
