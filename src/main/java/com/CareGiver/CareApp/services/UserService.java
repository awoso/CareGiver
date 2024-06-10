package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.User;
import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.*;
import com.CareGiver.CareApp.exceptions.CareAppException;

public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest request) throws CareAppException;

    UserUpdateProfileResponse updateProfile(UserUpdateProfileRequest request) throws CareAppException;

    UserLoginResponse login(UserLoginRequest request) throws CareAppException;

    UserLogoutResponse logout(UserLogoutRequest request) throws CareAppException;

    UserBookingResponse bookCareGiver(UserBookingRequest request) throws CareAppException;

    User findUserById(Long userId);

    void save(User existingUser);
}
