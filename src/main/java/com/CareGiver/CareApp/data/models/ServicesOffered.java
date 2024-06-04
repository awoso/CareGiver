package com.CareGiver.CareApp.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class ServicesOffered {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long careGiverId;
    private String name;
    private String description;
    private BigDecimal price;

}
