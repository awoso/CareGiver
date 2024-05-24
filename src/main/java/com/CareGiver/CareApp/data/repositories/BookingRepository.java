package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
