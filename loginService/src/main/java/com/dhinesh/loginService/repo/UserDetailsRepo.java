package com.dhinesh.loginService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhinesh.loginService.model.UserDetailsModel;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsModel, Integer>{

}
