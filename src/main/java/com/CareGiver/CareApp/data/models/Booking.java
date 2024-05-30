package com.CareGiver.CareApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long careGiverId;
    private Long userId;
    private String starTime;
    private String endTime;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private BookingStatus status= BookingStatus.PENDING;


}
