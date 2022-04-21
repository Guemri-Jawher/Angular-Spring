package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByEmail(String email);
	
	@Query("SELECT u FROM Users u WHERE u.id = :id ")
	Users finduserById(@Param("id") Long id);
	
	@Query("SELECT u FROM Users u WHERE u.role = :role ")
	List<Users> findUserByRole(@Param("role") String role);
	
	@Modifying
	@Query(value = "UPDATE Users u set u.password = :pwd", nativeQuery = true)
	void changeUserPassword(@Param("pwd") String pwd);
}
