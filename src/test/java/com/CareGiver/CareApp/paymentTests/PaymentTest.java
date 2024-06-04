package com.CareGiver.CareApp.paymentTests;

import com.CareGiver.CareApp.dtos.requests.PaymentRequest;
import com.CareGiver.CareApp.dtos.responses.PaymentResponse;
import com.CareGiver.CareApp.exceptions.CareAppException;
import com.CareGiver.CareApp.services.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaymentTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testThatPaymentCanBeMade() throws CareAppException {
        PaymentRequest request = new PaymentRequest();
        request.setUserId(1L);
        request.setBookingId(1L);
        request.setAmount(BigDecimal.valueOf(25000));

        PaymentResponse response = paymentService.makePayment(request);
        assertThat(response).isNotNull();

    }
}
