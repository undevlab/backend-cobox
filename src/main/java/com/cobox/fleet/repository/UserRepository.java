package com.cobox.fleet.repository;

import com.cobox.fleet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByDni(String dni);
    List<User> findByLevelOrderByNameAsc(String level);
    boolean existsByDni(String dni);
}