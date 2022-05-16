package com.training.advancejava.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.advancejava.librarymanagement.dao.UserRepository;
import com.training.advancejava.librarymanagement.entities.User;

@Service
public class UserRepositoryServices {

	@Autowired
	private UserRepository userRepository;
	
	public boolean verifyUser(String userId, String userPassword) {
		User user=this.userRepository.findByUserId(userId, userPassword);
		if(user!=null)
			return true;
		else
			return false;
	}
}
