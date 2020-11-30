package com.example.UserPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserPortal.model.User;


public interface UserRepository extends JpaRepository<User , Integer> {

	Optional<User> findByUsernameAndPassword(String username, String password);

}
