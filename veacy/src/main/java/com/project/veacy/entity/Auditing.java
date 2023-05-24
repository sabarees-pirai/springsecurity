package com.project.veacy.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "auditing_table")
public class Auditing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "created_by",referencedColumnName = "id")
	private User createdBy;
	
	private LocalDateTime createdAt;
	private LocalDateTime ModifiedAt;
	
	@OneToOne
	@JoinColumn(name = "modified_by",referencedColumnName = "id")
	private User modifiedBy;
	
}
