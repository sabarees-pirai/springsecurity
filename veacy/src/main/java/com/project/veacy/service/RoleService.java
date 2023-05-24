package com.project.veacy.service;

import java.util.List;
import java.util.Optional;

import com.project.veacy.entity.Role;
import com.project.veacy.model.RoleModel;

public interface RoleService {
	
	public Role createRole(Role role);

	public List<Role> getAllRole();

	public Optional<Role> getRoleByName(String name);

	public String updateRole(String name, RoleModel roleModel);

	public String deleteRole(int id);
}
