package com.project.veacy.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.veacy.entity.Auditing;
import com.project.veacy.entity.Role;
import com.project.veacy.entity.User;
import com.project.veacy.model.UserModel;
import com.project.veacy.repo.AuditingRepo;
import com.project.veacy.repo.UserRepo;
import com.project.veacy.util.AuditInput;

@RestController
public class UserControl {
	@Autowired
	UserRepo repo;
	
	@Autowired
	AuditingRepo auditRepo;
	
	AuditInput input = new AuditInput();

	
	@GetMapping("/user")
	public List<User> getall() {
		
		return repo.findAll();
	}
	
	@PostMapping("/user")
	public String apply(@RequestBody UserModel userModel) {
        
		User user = new User();
		BeanUtils.copyProperties(userModel, user);
		
		Role role = new Role(); 
		role.setId(userModel.getRoleId());
		user.setRoleId(role);
		
		User user1 = new User();
		user.setId(1);
		Auditing auditing = input.createTime(user1);
       
        
		auditRepo.save(auditing);
		
		user.setAuditingId(auditing);
		repo.save(user);
		
		return  "Data Posted";
	}

	@PostMapping("/user/{id}")
	public String update(@PathVariable int id,@RequestBody UserModel userModel) {
	
		User user = repo.findById(id).get();
		BeanUtils.copyProperties(userModel, user);
		
		Role role = new Role(); 
		role.setId(userModel.getRoleId());
		user.setRoleId(role);

		User user1 = new User();
		user.setId(2);

		Auditing auditing = auditRepo.findById(user.getAuditingId().getId()).get();
		
		input.modifiedTime(auditing, user1);
		
		auditRepo.save(auditing);
		
		repo.save(user);
		return "Data Updated";
	}

	@GetMapping("/user/{id}")
	public User getById(@PathVariable int id) {
		return repo.findById(id).get();
	}
	@DeleteMapping("/user/{id}")
	public String deleteRole(@PathVariable int id) {
		repo.deleteById(id);
		return "Deleted Successfully";
	}
	
}



