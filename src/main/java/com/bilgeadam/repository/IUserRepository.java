package com.bilgeadam.repository;


import com.bilgeadam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByEmailAndPassword(String email, String password);
}