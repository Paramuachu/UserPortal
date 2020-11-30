package com.example.UserPortal.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.UserPortal.model.Master;
import com.example.UserPortal.model.User;
import com.example.UserPortal.repository.MasterRepository;
import com.example.UserPortal.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class MainController {
	
	@Autowired
	public MasterRepository masterrepo;
	
	@Autowired
	public UserRepository userrepo;
	
	@GetMapping("/getvalue")
	public String getValue() {
		return "Hello GokulNath";
	}
	
	@GetMapping("/getMasters")
	public List<Master> getMaster() {
		System.out.println("Get Master User" + masterrepo.findAll());
		return masterrepo.findAll();
	}
	
	@GetMapping("/getUsers")
	public List<User> getUser() {
		System.out.println("Get Master User" + userrepo.findAll());
		return userrepo.findAll();
	}
	
	@PostMapping("/saveUsers")
	public User saveUser(@RequestBody User user, HttpServletRequest request) {
	//	LocalDate created_at = LocalDate.now();
	//	LocalDate Modified_at = LocalDate.now();
	//	user.setCreated_at(created_at.format(date));
		System.out.println("Get Master User" + userrepo.save(user));
		return userrepo.save(user);
	}
	
	@PostMapping("/loginUser")
	public Optional<Master> loginUser(@RequestBody Master master, HttpServletRequest request){
		boolean isActive;
//		if(masterrepo.findByUsernameAndPassword(master.getUsername(), master.getPassword()).isPresent()) {
//			isActive = master.isStatus();
//			System.out.println("Status is:" + master.isStatus());
//			if(isActive == false) {
//				master.setStatus(true);
//				isActive = master.isStatus();
//				System.out.println("After change" + isActive);
//			}
//		}
//		masterrepo.save(master);
		System.out.println("Find Master Admin" + masterrepo.findByUsernameAndPassword(master.getUsername(), master.getPassword()));
		return masterrepo.findByUsernameAndPassword(master.getUsername(), master.getPassword());
		
	}
	
	@PostMapping("/login")
	public Optional<User> login(@RequestBody User user, HttpServletRequest request){
		System.out.println("Find Master Admin" + userrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
		return userrepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	

}
