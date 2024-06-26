package com.CareGiver.CareApp.controllers;


import com.CareGiver.CareApp.dtos.requests.PaymentRequest;
import com.CareGiver.CareApp.dtos.responses.PaymentResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payment/")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("makePayment")
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequest paymentRequest) throws CareAppException {
        return new ResponseEntity<>(paymentService.makePayment(paymentRequest), HttpStatus.CREATED);
    }

}
