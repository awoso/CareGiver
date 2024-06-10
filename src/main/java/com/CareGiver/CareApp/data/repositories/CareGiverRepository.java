package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.CareGiver;
import com.CareGiver.CareApp.data.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareGiverRepository extends JpaRepository<CareGiver,Long> {
    CareGiver findByEmail(String email);
    List<CareGiver> findCareGiversByLocation(Location location);

//    CareGiver findByLocation(Location location);
}
