package com.project.veacy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.veacy.entity.Auditing;

public interface AuditingRepo extends JpaRepository<Auditing, Integer> {

}
