package com.training.advancejava.librarymanagement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.advancejava.librarymanagement.entities.User;

public interface UserRepository extends CrudRepository<User, String>{
	@Query("from User where userId=:u_id and userPassword=:u_pass")
	public User findByUserId(@Param("u_id") String userId, @Param("u_pass") String userPass);

}