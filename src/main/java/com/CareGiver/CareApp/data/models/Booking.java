package com.CareGiver.CareApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long careGiverId;
    private Long userId;
    private Long serviceOfferedId;
    private String starTime;
    private String endTime;
    private BookingStatus status;
}
