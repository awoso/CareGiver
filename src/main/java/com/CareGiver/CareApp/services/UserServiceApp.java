package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.data.models.Admin;
import com.CareGiver.CareApp.data.models.Booking;
import com.CareGiver.CareApp.data.models.User;
import com.CareGiver.CareApp.data.repositories.BookingRepository;
import com.CareGiver.CareApp.data.repositories.UserRepository;
import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.*;
import com.CareGiver.CareApp.exceptions.CareAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceApp implements UserService{

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) throws CareAppException {
        boolean isRegistered = userRepository.findByEmail(request.getEmail())!=null;
        if (isRegistered) throw new CareAppException("User details already taken");

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAddress(request.getAddress());
        user.setName(request.getName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(user.getId());
        response.setMessage("User registration successfully");

        return response;
    }

    @Override
    public UserUpdateProfileResponse updateProfile(UserUpdateProfileRequest request) throws CareAppException {
        User existingUser = userRepository.findById(request.getId()).orElse(null);
        if (existingUser == null) throw new CareAppException("User not found");
        if (!existingUser.isLogin()) throw new CareAppException("Dear " + existingUser.getName() + " kindly login to update your profile");
        existingUser.setName(request.getName());
        existingUser.setPhoneNumber(request.getPhoneNumber());
        existingUser.setAddress(request.getAddress());
        existingUser.setEmail(request.getEmail());
        existingUser.setPassword(request.getPassword());
        existingUser.setUpdatedAt(LocalDateTime.now());
        userRepository.save(existingUser);

       UserUpdateProfileResponse response = new UserUpdateProfileResponse();
        response.setMessage("User successfully updated");
        response.setId(existingUser.getId());

        return response;

    }

    @Override
    public UserLoginResponse login(UserLoginRequest request) throws CareAppException {
        User existinguser = userRepository.findByEmail(request.getEmail());
        if (existinguser == null) throw new CareAppException("Admin not found");
        if (!existinguser.getPassword().equals(request.getPassword())) throw new CareAppException("Invalid password");
        existinguser.setLogin(true);
        userRepository.save(existinguser);
        UserLoginResponse response = new UserLoginResponse();
        response.setMessage("Admin successfully logged in");
        return response;
    }

    @Override
    public void logout(UserLogoutRequest request) throws CareAppException {
        User existingUser = userRepository.findById(request.getUserId()).orElse(null);
        if (existingUser == null) throw new CareAppException("User not found");
        existingUser.setLogin(false);
        userRepository.save(existingUser);
    }

    @Override
    public UserBookingResponse bookCareGiver(UserBookingRequest request) throws CareAppException {
        User existingUser = userRepository.findById(request.getUserId()).orElse(null);
        if (existingUser==null) throw new CareAppException("Kindly register to book a Caregiver service. Thanks");
        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setCareGiverId(request.getCareGiverId());
        booking.setStarTime(request.getStarTime());
        booking.setEndTime(request.getEndTime());
        booking.setCreatedAt(LocalDateTime.now());

        bookingRepository.save(booking);

        List<Booking> existingUserBookings = new ArrayList<>();

        existingUserBookings.add(booking);

        existingUser.setBookings(existingUserBookings);
        userRepository.save(existingUser);
        UserBookingResponse response = new UserBookingResponse();
        response.setMessage("Dear "  + existingUser.getName()  + " your booking was successful.");
        response.setBookingId(booking.getId());
        return response;
    }
}
