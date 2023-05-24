package com.project.veacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.veacy.entity.Auditing;
import com.project.veacy.repo.AuditingRepo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AuditingController {

	@Autowired
	AuditingRepo auditRepo;
	
	
	@Operation(summary = "GetAll", description = "Method to get all Auditing Details")
	@GetMapping("/audit")
	public List<Auditing> getall() {
		
		return auditRepo.findAll();
	}
	
	@PostMapping("/audit")
	public String apply(@RequestBody Auditing auditing) {
		auditRepo.save(auditing);
		return null;
	}
//	
//	@PostMapping("/audit/{id}/{name}")
//	public String update(@PathVariable int id,@PathVariable int name) {
//		
//		Auditing p = auditRepo.findById(id).get();
//		p.setCreatedBy(name);
//		auditRepo.save(p);
//		return "Data Updated";
//	}
//
//	@GetMapping("/audit/{id}")
//	public Auditing getById(@PathVariable int id) {
//		
//		return auditRepo.findById(id).get();
//	}
}
