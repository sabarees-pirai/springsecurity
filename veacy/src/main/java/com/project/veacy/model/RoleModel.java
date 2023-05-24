package com.project.veacy.model;

import com.project.veacy.entity.Auditing;
import com.project.veacy.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleModel {
	 private int id;
	 private String name;
	 private String description;
	 private boolean isInvitee;
	 private Integer moduleId;
	 private boolean isDeleted;
	 private boolean isActive;
	 private Auditing auditing;

	
	
}
