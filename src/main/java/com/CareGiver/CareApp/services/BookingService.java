package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.Booking;
import com.CareGiver.CareApp.dtos.requests.UserBookingRequest;
import com.CareGiver.CareApp.dtos.responses.UserBookingResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;

public interface BookingService {


    UserBookingResponse bookService(UserBookingRequest request) throws Exception, CareAppException;

    Booking findById(Long bookingId);

    UserBookingResponse userBooking(UserBookingRequest request);

}
