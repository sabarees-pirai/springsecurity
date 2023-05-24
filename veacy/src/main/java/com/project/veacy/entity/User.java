package com.project.veacy.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_table")
@SQLDelete(sql = "UPDATE user_table SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@Validated
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	
	 @Column(unique = true)
	private String email;
	 
	private String mobile;
	
	 @Column(unique = true)
	private String username;
	 
	@OneToOne
	@JoinColumn(name = "role_id",referencedColumnName = "id")
	private Role roleId;
	
	@OneToOne
	@JoinColumn(name = "auditing_id",referencedColumnName = "id")
	private Auditing auditingId;

	private Boolean isDeleted = false;
	private Boolean isActive = true;
}
