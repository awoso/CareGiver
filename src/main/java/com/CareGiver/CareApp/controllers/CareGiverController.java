package com.CareGiver.CareApp.controllers;


import com.CareGiver.CareApp.dtos.requests.*;
import com.CareGiver.CareApp.dtos.responses.*;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.CareGiverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/CareGiver/")
@AllArgsConstructor
public class CareGiverController {
    private CareGiverService careGiverService;

@PostMapping("register")
    public ResponseEntity<CareGiverRegistrationResponse> register(@RequestBody CareGiverRegistrationRequest request) throws CareAppException {
        return new ResponseEntity<>(careGiverService.registerCareGiver(request), HttpStatus.CREATED);

    }

@GetMapping("login")
    public ResponseEntity<CareGiverResponse> login(@RequestBody CareGiverLoginRequest request) throws CareAppException {
    return new ResponseEntity<>(careGiverService.login(request), HttpStatus.OK);

}

//@PostMapping("logout")
//    public ResponseEntity<CareGiverResponse> logout1(@RequestBody CareGiverLogoutRequest request) throws CareAppException {
//
//}
@PostMapping("logout")
public void logout(@RequestBody CareGiverLogoutRequest request){
    CareGiverResponse response = new CareGiverResponse();
    try {
         careGiverService.logout(request);
         response.setMessage("Logged out successfully");
        System.out.println(response.getMessage());

    } catch (CareAppException e) {
        e.getMessage();
    }
}


}
