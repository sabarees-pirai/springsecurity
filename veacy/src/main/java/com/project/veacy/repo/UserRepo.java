package com.project.veacy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.veacy.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
