package com.vignesh.springboot_playground.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vignesh.springboot_playground.model.User;

public interface UserService extends CrudRepository<User, Long> {
//	@Query("select u from User u where u.username = :username")
	public Optional<User> findByUsername(String username);
}
