package com.project.veacy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	private String name;
	private String email;
	private String mobile;
	private String username;
	private Integer roleId;
	private Boolean isActive = true;
	private RoleModel roleModel;
}
