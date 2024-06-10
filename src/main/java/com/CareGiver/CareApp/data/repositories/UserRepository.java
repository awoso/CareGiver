package com.CareGiver.CareApp.data.repositories;

import com.CareGiver.CareApp.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    User findUserById(Long userId);
}
