package com.CareGiver.CareApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter

public class PaymentRequest {
    private Long bookingId;
    private Long userId;
    private BigDecimal amount;
}
