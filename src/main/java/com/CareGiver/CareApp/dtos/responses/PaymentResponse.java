package com.CareGiver.CareApp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentResponse {
    private Long paymentId;
    private String message;
}
