package com.project.veacy.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.project.veacy.entity.Auditing;
import com.project.veacy.entity.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuditInput {
	

	public LocalDateTime value(LocalDateTime time) {
		
		log.info("Input LocalDateTime : "+time);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = time.format(formatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTime, formatter);
		
        log.info("Formatted LocalDateTime : "+parsedDateTime);
        
		return parsedDateTime;
	}
	
	public Auditing createTime(User user) {
		
		Auditing auditing = new Auditing();
		
		log.info("Input user for Auditing : "+user);
		
		auditing.setCreatedBy(user);
		auditing.setModifiedBy(user);
		
		LocalDateTime currentTimestamp = LocalDateTime.now();
		LocalDateTime time = value(currentTimestamp);
		auditing.setCreatedAt(time);
		auditing.setModifiedAt(time);
		
		log.info("Output Data of Auditing : "+auditing.getCreatedBy().getName()+" "+auditing.getCreatedAt()+" "+auditing.getModifiedBy().getName()+" "+auditing.getModifiedAt());
		
		return auditing;
	}
	
	public Auditing modifiedTime(Auditing auditing,User user) {
		
		log.info("Input user for Auditing : "+user);
		
		LocalDateTime currentTimestamp = LocalDateTime.now();
		LocalDateTime time = value(currentTimestamp);
		auditing.setModifiedBy(user);
		auditing.setModifiedAt(time);
		
		log.info("Updated Data of Auditing : "+auditing.getModifiedBy().getName()+" "+auditing.getModifiedAt());
		
		return auditing;
	}
	
}
