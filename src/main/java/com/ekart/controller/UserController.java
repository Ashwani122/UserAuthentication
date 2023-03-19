package com.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.Dto.UserDto;
import com.ekart.service.userService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/register")
public class UserController {

	@Autowired
	private userService userService;
	
	@GetMapping("/fetch")
	public ResponseEntity<List<UserDto>> details(){
		return ResponseEntity.ok(userService.fetch());
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> login(
		    @RequestParam("email") String email,
			@RequestParam("pwd") String password){
		return ResponseEntity.ok(userService.checkCredentials(email,password));
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> savEntity(
			@RequestBody UserDto user){
		return ResponseEntity.ok(userService.create(user));
	}
	
}
