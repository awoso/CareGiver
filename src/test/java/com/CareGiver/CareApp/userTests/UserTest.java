package com.CareGiver.CareApp.userTests;

import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.*;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void testThatAUserCanRegister() throws CareAppException {

        UserRegistrationRequest request= new UserRegistrationRequest();
        request.setName("Tolu");
        request.setPassword("123456");
        request.setEmail("tolu@gmail.com");
        request.setPhoneNumber("1234567890");
        request.setAddress("Oshodi");
        request.setPhoneNumber("08145093822");

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
    public void testThatAListOfUserBookingCanBeFound() throws CareAppException {
        ViewAllUserBookingRequest request = new ViewAllUserBookingRequest();
        request.setUserId(1L);

        ViewAllUserBookingResponse response = userService.getAllBookings(request);
        System.out.println(response.getUserBookings().size());
        assertThat(response).isNotNull();

    }


}
