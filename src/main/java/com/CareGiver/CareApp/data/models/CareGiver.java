package com.CareGiver.CareApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class CareGiver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CareGiverId;
    private String userName;
    private String email;
    private String password;
    private String servicesOffered;
    private String qualification;
    private int yearsOfExperience;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isLogin;
    private boolean isAvailable;
    @Enumerated(EnumType.STRING)
    private Location location;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Booking> bookings ;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Review> reviews;
    @OneToOne(fetch = FetchType.EAGER, cascade =CascadeType.DETACH)
    private Image image;

}
