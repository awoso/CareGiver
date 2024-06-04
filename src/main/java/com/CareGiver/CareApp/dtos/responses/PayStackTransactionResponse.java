package com.CareGiver.CareApp.dtos.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PayStackTransactionResponse {
    private boolean status;
    private String message;
    @JsonProperty("data")
    private PaystackTransactionDetails paystackTransactionDetails;
}
