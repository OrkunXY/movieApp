package com.bilgeadam.repository;


import com.bilgeadam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByEmailAndPassword(String email, String password);
    List<User> findByNameOrderByNameAsc(String name);
    boolean existsByName(String name);
    List<User> findByNameContainingIgnoreCaseOrderBySurnameAsc(String name);
    List<User> findByNameContainingIgnoreCase(String name);
    List<User> findAllByNameOrderByNameAsc(String name);
    Optional<User> findByEmail(String email);

}