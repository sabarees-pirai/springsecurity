package com.project.veacy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.veacy.entity.Role;
import com.project.veacy.model.RoleModel;
import com.project.veacy.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PostMapping("/create")
	public Role createRole(@RequestBody Role role){
		return roleService.createRole(role);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Role>> getAllRole(){
		List<Role> role = roleService.getAllRole();
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	@GetMapping("/get/{name}")
	public ResponseEntity<Optional<Role>> getRoleByName(@PathVariable("name") String name){
		Optional<Role> role = roleService.getRoleByName(name);
		if(role !=null) {
			return ResponseEntity.ok(role);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/update/{name}")
	public String updateRole(@PathVariable String name, @RequestBody RoleModel roleModel){
		String role = roleService.updateRole(name, roleModel);
		return role;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteRole(@PathVariable int id) {
		roleService.deleteRole(id);
		return "deleted Successfully";
	}
}
