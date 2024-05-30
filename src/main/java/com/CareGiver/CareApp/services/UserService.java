package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.UserBookingResponse;
import com.CareGiver.CareApp.dtos.responses.UserLoginResponse;
import com.CareGiver.CareApp.dtos.responses.UserRegistrationResponse;
import com.CareGiver.CareApp.dtos.responses.UserUpdateProfileResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;

public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest request) throws CareAppException;

    UserUpdateProfileResponse updateProfile(UserUpdateProfileRequest request) throws CareAppException;

    UserLoginResponse login(UserLoginRequest request) throws CareAppException;

    void logout(UserLogoutRequest request) throws CareAppException;

    UserBookingResponse bookCareGiver(UserBookingRequest request) throws CareAppException;
}
