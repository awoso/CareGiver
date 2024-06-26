package com.CareGiver.CareApp.controllers;


import com.CareGiver.CareApp.dtos.requests.AdminLogOutRequest;
import com.CareGiver.CareApp.dtos.requests.AdminLoginRequest;
import com.CareGiver.CareApp.dtos.requests.AdminRegistrationRequest;
import com.CareGiver.CareApp.dtos.responses.AdminLoginResponse;
import com.CareGiver.CareApp.dtos.responses.AdminLogoutResponse;
import com.CareGiver.CareApp.dtos.responses.AdminRegistrationResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin/")
@AllArgsConstructor
public class AdminController {
    private AdminService adminService;

    @PostMapping("register")
    public ResponseEntity<AdminRegistrationResponse> register(@RequestBody AdminRegistrationRequest request) throws CareAppException {

        return ResponseEntity.status((HttpStatus.CREATED)).body(adminService.registerAdmin(request));
    }

    @PostMapping("login")
    public ResponseEntity<AdminLoginResponse> login(@RequestBody AdminLoginRequest request) throws CareAppException {

        return ResponseEntity.status((HttpStatus.OK)).body(adminService.login(request));
    }
//    @PostMapping("logout")
//    public ResponseEntity<AdminLogOutResponse> logout(@RequestBody AdminLogOutRequest request) throws CareAppException {
//
//        return ResponseEntity.status((HttpStatus.OK)).body(adminService.logout(request));
//    }



}





