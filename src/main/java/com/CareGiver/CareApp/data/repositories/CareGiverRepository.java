package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.CareGiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareGiverRepository extends JpaRepository<CareGiver,Long> {
}
