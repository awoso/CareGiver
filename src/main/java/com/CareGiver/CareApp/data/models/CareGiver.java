package com.CareGiver.CareApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class CareGiver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String qualification;
    private int yearsOfExperience;
    private LocalDate createdAt;
    private LocalDateTime updatedAt;
    private boolean isLogin;
    private boolean isAvailable;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ServicesOffered> servicesOffered;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Booking> bookings ;

}
