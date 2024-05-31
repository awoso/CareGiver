package com.CareGiver.CareApp.adminTests;

import com.CareGiver.CareApp.data.models.User;
import com.CareGiver.CareApp.data.repositories.AdminRepository;
import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.AdminLoginResponse;
import com.CareGiver.CareApp.dtos.responses.AdminRegistrationResponse;
import com.CareGiver.CareApp.dtos.responses.AdminUpdateProfileResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AdminTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testThatAdminCanRegister() throws CareAppException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("awosoOgaga@gmail.com");
        request.setPassword("awoso1234");
        request.setUserName("Awoso");
        adminService.registerAdmin(request);
        AdminRegistrationResponse response = adminService.registerAdmin(request);

        assertThat(response).isNotNull();
//        assertEquals(1,adminRepository.count());

    }

    @Test
    public void testThatMultipleAdminCanRegister() throws CareAppException {
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("awosoAgba02@gmail.com");
        request.setPassword("awoso4567");
        request.setUserName("Awoso2");

        AdminRegistrationResponse response = adminService.registerAdmin(request);

        assertThat(response).isNotNull();

    }
    @Test
    public void testThatIfAdminAttemptsToRegisterWithSameEmailExceptionIsThrown(){
        AdminRegistrationRequest request = new AdminRegistrationRequest();
        request.setEmail("awosoAgba02@gmail.com");
        request.setPassword("awoso4567");
        request.setUserName("Awoso2");

        assertThrows(CareAppException.class,()->adminService.registerAdmin(request));

    }

    @Test
    public void testThatAdminCanLogin() throws CareAppException {
        AdminLoginRequest request = new AdminLoginRequest();
        request.setEmail("awosoAgba02@gmail.com");
        request.setPassword("awoso4567");
        AdminLoginResponse response = adminService.login(request);

        assertThat(response).isNotNull();


    }
    @Test
    public void testThatAdminCanLogout() throws CareAppException{
        AdminLogOutRequest request = new AdminLogOutRequest();
        request.setAdminId(1L);
        adminService.logout(request);


    }

//    UserLogoutRequest request = new UserLogoutRequest();
//        request.setUserId(1L);
//        userService.logout(request);
//    User user = userRepository.findById(1L).orElse(null);
//
//        assert user != null;
//    assertFalse(user.isLogin());
//




    @Test
    public void testThatAdminCanUpdateProfile() throws CareAppException {
    AdminUpdateProfileRequest request = new AdminUpdateProfileRequest();
    request.setAdminId(2L);
    request.setEmail("awosoCoder@gmail.com");
    request.setPassword("NewPassword");
    request.setUserName("NewAwoso");

    AdminUpdateProfileResponse response = adminService.updateAdmin(request);

    assertThat(response).isNotNull();


    }

    @Test
    public void testThatAdminCanBeDeleted() throws CareAppException {
        DeleteAdminRequest request = new DeleteAdminRequest();
        request.setAdminId(1L);
        adminService.deleteAdmin(request);
        assertEquals(adminRepository.count(),1);
    }

    @Test
    public void testThatAllAdminsCanBeFound(){
        adminService.findAllAdmins(adminRepository.findAll());
        assertEquals(adminRepository.count(),3);
        System.out.println(adminRepository.count());
    }
}
