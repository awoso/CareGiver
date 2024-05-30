package com.CareGiver.CareApp.controllers;

import com.CareGiver.CareApp.dtos.requests.UserBookingRequest;
import com.CareGiver.CareApp.dtos.requests.UserLoginRequest;
import com.CareGiver.CareApp.dtos.requests.UserRegistrationRequest;
import com.CareGiver.CareApp.dtos.responses.UserBookingResponse;
import com.CareGiver.CareApp.dtos.responses.UserLoginResponse;
import com.CareGiver.CareApp.dtos.responses.UserRegistrationResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/User/")
@AllArgsConstructor
public class UserController {
    private UserService userService;

@PostMapping("register")
    public ResponseEntity<UserRegistrationResponse> register(@RequestBody UserRegistrationRequest request) throws CareAppException {
    return new ResponseEntity<>(userService.registerUser(request), HttpStatus.CREATED);
}

@GetMapping("login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) throws CareAppException {
    return new ResponseEntity<>(userService.login(request), HttpStatus.OK);


}
@PostMapping("bookService")
    public ResponseEntity<UserBookingResponse> bookService(@RequestBody UserBookingRequest request) throws CareAppException {
    return new ResponseEntity<>(userService.bookCareGiver(request), HttpStatus.CREATED);
}


}
