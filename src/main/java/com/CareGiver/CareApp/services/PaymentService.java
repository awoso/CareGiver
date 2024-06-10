package com.CareGiver.CareApp.services;


import com.CareGiver.CareApp.dtos.requests.PaymentRequest;
import com.CareGiver.CareApp.dtos.responses.PaymentResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;

public interface PaymentService {
    PaymentResponse makePayment(PaymentRequest request) throws CareAppException;
}
