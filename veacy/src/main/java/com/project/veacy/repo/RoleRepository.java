package com.project.veacy.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.veacy.entity.Role;



public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(String name);

}
