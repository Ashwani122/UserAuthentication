package com.ekart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.entity.User;

@Repository
public interface userRepo extends JpaRepository<User, Integer>{

	List<User> findByEmail(String email);

}