package com.CareGiver.CareApp.data.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long bookingId;
    private Long userId;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
//    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private Booking booking;

}
