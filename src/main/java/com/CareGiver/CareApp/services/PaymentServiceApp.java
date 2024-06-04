package com.CareGiver.CareApp.services;

import com.CareGiver.CareApp.configs.app.PayStackConfig;
import com.CareGiver.CareApp.data.models.Booking;
import com.CareGiver.CareApp.data.models.Payment;
import com.CareGiver.CareApp.data.models.PaymentType;
import com.CareGiver.CareApp.data.models.User;
import com.CareGiver.CareApp.data.repositories.BookingRepository;
import com.CareGiver.CareApp.data.repositories.PaymentRepository;
import com.CareGiver.CareApp.dtos.requests.InitializeTransactionRequest;
import com.CareGiver.CareApp.dtos.requests.PaymentRequest;
import com.CareGiver.CareApp.dtos.responses.PayStackTransactionResponse;
import com.CareGiver.CareApp.dtos.responses.PaymentResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PaymentServiceApp implements PaymentService{

    private final UserService userService;
    private final BookingService bookingService;
    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final PayStackConfig config;

    @Override
    public PaymentResponse makePayment(PaymentRequest request) throws CareAppException {
        User existingUser = userService.findById(request.getUserId()).orElse(null);
        if (existingUser == null) throw new CareAppException("User not found");
        List<Payment> userExistingPaymentList = existingUser.getPayments();
        Booking booking = bookingService.findById(request.getBookingId());

        Payment payment = new Payment();
        payment.setUserId(existingUser.getId());
        payment.setBookingId(booking.getId());
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);



        userExistingPaymentList.add(payment);
        existingUser.setPayments(userExistingPaymentList);
        userService.save(existingUser);
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentId(payment.getId());
        paymentResponse.setMessage("Payment successful");

        RestTemplate template = new RestTemplate();
        HttpEntity<InitializeTransactionRequest> transactionRequest = buildPayment(existingUser, payment);

        ResponseEntity<PayStackTransactionResponse> transactionResponseResponse =
                template.postForEntity(config.getPayStackBaseUrl(),transactionRequest,PayStackTransactionResponse.class);

        System.out.println(Objects.requireNonNull(transactionResponseResponse.getBody()).getPaystackTransactionDetails().getAuthorizationUrl());


        return paymentResponse;
    }

    private HttpEntity<InitializeTransactionRequest> buildPayment(User existingUser, Payment payment) {
        InitializeTransactionRequest request = new InitializeTransactionRequest();
        request.setEmail(existingUser.getEmail());
        request.setAmount(String.valueOf(payment.getAmount().multiply(BigDecimal.valueOf(100))));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + config.getPayStackApiKey());
        return new HttpEntity<>(request, headers);
    }
}
