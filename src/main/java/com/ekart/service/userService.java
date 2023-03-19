package com.ekart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.Dto.UserDto;
import com.ekart.entity.User;
import com.ekart.repository.userRepo;

@Service
public class userService {

	@Autowired
	private userRepo userRepo;
	
	public String create(UserDto user) {
		try {
			User entityUser = new User();
			entityUser.setUserName(user.getUserName());
			entityUser.setEmail(user.getEmail());
			entityUser.setPassword(user.getPassword());
			entityUser.setName(user.getName());
			userRepo.save(entityUser);
		} catch (Exception e) {
			System.out.println("Error");
		}
		return "Success";
	}

	public List<UserDto> fetch() {
		List<User> user = userRepo.findAll();
		List<UserDto> userDtos=new ArrayList<>();
		user.stream().forEach(x->{
			UserDto dto=new UserDto();
			dto.setName(x.getName());
			dto.setUserId(x.getUserId());
			dto.setEmail(x.getEmail());
			dto.setPassword(x.getPassword());
			dto.setUserName(x.getUserName());
			userDtos.add(dto);
		});
		return userDtos;
	}

	public String checkCredentials(String email,String password) {
		try {
			List<User>  user=userRepo.findByEmail(email);
			Boolean checkBoolean=user.stream().anyMatch(x->x.getPassword().equals(password));
			if(checkBoolean) {
				return "Login successful";
			}
		} catch (Exception e) {
			System.err.println("Something bad happened");
		}
		
		return "Incorrect userName or Password";
	}
}
