package com.CareGiver.CareApp.userTests;

import com.CareGiver.CareApp.data.models.User;
import com.CareGiver.CareApp.data.repositories.UserRepository;
import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.*;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testThatAUserCanRegister() throws CareAppException {

        UserRegistrationRequest request= new UserRegistrationRequest();
        request.setName("Tolu");
        request.setPassword("123456");
        request.setEmail("tolu@gmail.com");
        request.setPhoneNumber("1234567890");
        request.setAddress("Oshodi");

        UserRegistrationResponse response = userService.registerUser(request);
        assertThat(response).isNotNull();

    }

    @Test
    public void testThatUserCanLogin() throws CareAppException {
        UserLoginRequest request = new UserLoginRequest();
        request.setEmail("tolu@gmail.com");
        request.setPassword("123456");
        UserLoginResponse response = userService.login(request);
        assertThat(response).isNotNull();


    }

    @Test
    public void testThatUserCanLogout() throws CareAppException {
        UserLogoutRequest request = new UserLogoutRequest();
        request.setEmail("tolu@gmail.com");

        UserLogoutResponse response = userService.logout(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThatUserCanUpdateProfile() throws CareAppException {
        UserUpdateProfileRequest request = new UserUpdateProfileRequest();
        request.setId(1L);
        request.setName("Tolu Olowookere");
        request.setPassword("toluolowo");
        request.setEmail("toluolowo@gmail.com");
        request.setPhoneNumber("+1234567890");
        request.setAddress("Alabama");

        UserUpdateProfileResponse response = userService.updateProfile(request);

        assertThat(response).isNotNull();
    }

    @Test
    public void testThatAUserCanBookASpecificCareGiver() throws CareAppException {
        UserBookingRequest request = new UserBookingRequest();
        request.setUserId(1L);
        request.setCareGiverId(1L);
        request.setStarTime("30/05/2024");
        request.setEndTime("12/06/2024");

        UserBookingResponse response = userService.bookCareGiver(request);
        assertThat(response).isNotNull();
    }


}
