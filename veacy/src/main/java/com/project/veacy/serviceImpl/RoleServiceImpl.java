package com.project.veacy.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.veacy.entity.Auditing;
import com.project.veacy.entity.Role;
import com.project.veacy.entity.User;
import com.project.veacy.model.RoleModel;
import com.project.veacy.repo.AuditingRepo;
import com.project.veacy.repo.RoleRepository;
import com.project.veacy.repo.UserRepo;
import com.project.veacy.service.RoleService;
import com.project.veacy.util.AuditInput;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AuditingRepo auditRepo;
	
	@Autowired
	UserRepo repo;
	
	AuditInput input = new AuditInput();
	
	@Override
	public Role createRole(Role role) {

		User user = new User();
		user.setId(1);
		
		Auditing auditing = input.createTime(user);
		
		auditRepo.save(auditing);
		
		role.setAuditing(auditing);
		
        return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> getRoleByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public String updateRole(String name, RoleModel roleModel) {
		Optional<Role> optionalRole = roleRepository.findByName(name);
		if(optionalRole.isPresent()) {
			Role role = optionalRole.get();
			role.setName(roleModel.getName());
			role.setDescription(roleModel.getDescription());
			role.setInvitee(roleModel.isInvitee());
			role.setModuleId(roleModel.getModuleId());
			

			Auditing auditing = auditRepo.findById(role.getAuditing().getId()).get();
			
			User user = new User();
			user.setId(2);
			input.modifiedTime(auditing, user);

			auditRepo.save(auditing);
			
			roleRepository.save(role);
			return "Updated Successfully";
		}
		else {
			return "Invalid Request";
		}
	}

	@Override
	public String deleteRole(int id) {
		roleRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
	
	
	

}
