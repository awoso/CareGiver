package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
