package com.jankenfighteralpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jankenfighteralpha.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
	@Query(value = "SELECT u FROM Users u WHERE u.userId = ?1")
	Users findById(int userId);
	@Query(value = "SELECT u FROM Users u WHERE u.email = ?1 AND u.password = ?2")
	Users verifyLogin(String email, String password);
	@Query(value = "SELECT u.userId FROM Users u WHERE u.email = ?1")
	Integer getId(String email);
	@Query(value = "SELECT u.userId FROM Users u WHERE u.userName = ?1")
	Integer nameGetId(String userName);
	@Query(value = "SELECT u FROM Users u WHERE u.userName = ?1")
	Users findByName(String userName);
}
