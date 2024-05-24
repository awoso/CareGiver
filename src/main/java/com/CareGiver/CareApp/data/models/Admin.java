package com.CareGiver.CareApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private LocalDate createdAt;
    private LocalDateTime updatedAt;
    private boolean isLogin;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<User> users;
}
