package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.ServicesOffered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesOfferedRepository extends JpaRepository<ServicesOffered, Long> {
}
