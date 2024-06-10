package com.CareGiver.CareApp.controllers;
import com.CareGiver.CareApp.dtos.requests.UserBookingRequest;
import com.CareGiver.CareApp.dtos.responses.UserBookingResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/bookService/")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("booking")
    public ResponseEntity<UserBookingResponse> booking(@RequestBody UserBookingRequest request) throws CareAppException, Exception {
     return new ResponseEntity<>(bookingService.bookService(request), HttpStatus.CREATED);
    }
}
