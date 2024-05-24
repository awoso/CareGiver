package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
}
