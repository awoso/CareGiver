package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
