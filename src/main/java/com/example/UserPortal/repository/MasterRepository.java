package com.example.UserPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserPortal.model.Master;


public interface MasterRepository extends JpaRepository<Master , Integer> {

	Optional<Master> findByUsernameAndPassword(String username, String password);
	

}
