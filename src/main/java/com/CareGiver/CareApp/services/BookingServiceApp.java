package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.Booking;
import com.CareGiver.CareApp.data.models.BookingStatus;
import com.CareGiver.CareApp.data.models.CareGiver;
import com.CareGiver.CareApp.data.models.User;
import com.CareGiver.CareApp.data.repositories.BookingRepository;
import com.CareGiver.CareApp.dtos.requests.UserBookingRequest;
import com.CareGiver.CareApp.dtos.responses.UserBookingResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceApp implements BookingService{
    private final UserService userService;
    private final CareGiverService careGiverService;
    private final BookingRepository bookingRepository;

    @Override
    public UserBookingResponse bookService(UserBookingRequest request) throws CareAppException {

        User existingUser = userService.findById(request.getUserId()).orElse(null);
        if (existingUser==null) throw new CareAppException("Kindly register to place a booking");

        CareGiver existingCareGiver = careGiverService.findById(request.getCareGiverId());
        if (existingCareGiver==null) throw new CareAppException("CareGiver not found");

        Booking booking = new Booking();
        booking.setUserId(existingUser.getId());
        booking.setCareGiverId(existingCareGiver.getCareGiverId());
        booking.setStarTime(request.getStarTime());
        booking.setEndTime(request.getEndTime());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setCreatedAt(LocalDateTime.now());
        bookingRepository.save(booking);

        List<Booking> existingUserBookings = existingUser.getBookings();
        existingUserBookings.add(booking);

        List<Booking> existingCareGiverBookings = existingCareGiver.getBookings();
        existingCareGiverBookings.add(booking);



        userService.save(existingUser);
        careGiverService.save(existingCareGiver);

        UserBookingResponse response = new UserBookingResponse();
        response.setBookingId(booking.getId());
        response.setMessage("Booking successfully submitted");

        return response;
    }

    @Override
    public Booking findById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }
}
