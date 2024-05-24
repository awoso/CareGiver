package com.CareGiver.CareApp.controllers;


import com.CareGiver.CareApp.dtos.requests.AdminRegistrationRequest;
import com.CareGiver.CareApp.dtos.responses.AdminRegistrationResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/")
@AllArgsConstructor
public class AdminController {
    private AdminService adminService;

    @PostMapping("register")
    public ResponseEntity<AdminRegistrationResponse> register(@RequestBody AdminRegistrationRequest request) throws CareAppException {

        return ResponseEntity.status((HttpStatus.CREATED)).body(adminService.registerAdmin(request));
    }
}
