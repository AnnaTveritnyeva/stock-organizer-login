package com.anna.tveritnyeva.stockorganizerlogin.repositories;

import com.anna.tveritnyeva.stockorganizerlogin.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
