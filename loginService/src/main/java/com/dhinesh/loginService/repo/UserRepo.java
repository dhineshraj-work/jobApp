package com.dhinesh.loginService.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhinesh.loginService.model.UserModel;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{

	Optional<UserModel> findByEmail(String email);

	boolean existsByEmail(String email);

	@Transactional
	void deleteByEmail(String email);
}
