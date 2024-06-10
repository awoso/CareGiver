package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
