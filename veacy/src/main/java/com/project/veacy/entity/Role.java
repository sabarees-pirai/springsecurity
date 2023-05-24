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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@SQLDelete(sql = "UPDATE role SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name = "is_invitee")
	private boolean isInvitee = false;
	
	@Column(name = "is_deleted")
	private boolean isDeleted = false;
	
	@Column(name = "is_active")
	private boolean isActive = true;
	

    @Column(name = "module_id")
	private Integer moduleId;	
	
	@OneToOne
	@JoinColumn(name = "auditing_id",referencedColumnName = "id")
	private Auditing auditing;
}
