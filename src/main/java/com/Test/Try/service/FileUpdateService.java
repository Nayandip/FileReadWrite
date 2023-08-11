//package io.nayandip.filereadwriteservice.Service;
package com.Test.Try.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Test.Try.dao.FileUpdateDAO;
import com.Test.Try.model.FileUpdateModel;

//
//import io.nayandip.filereadwriteservice.dao.FileUpdateDAO;
//import io.nayandip.filereadwriteservice.model.FileUpdateModel;

@Service
public class FileUpdateService {
	
	@Autowired
	FileUpdateDAO fileUpdateDAO;
	
	@Transactional
	public void addFileinfo(FileUpdateModel fileUpdate)
	{
		
		fileUpdateDAO.addFileUpdate(fileUpdate);
		
	}
	
	public FileUpdateModel addOrUpdateFileinfo(FileUpdateModel fileUpdate)
	{
		
		
		System.out.println("Hi! before the insert service call");
		
		fileUpdateDAO.addOrUpdateFileUpdate(fileUpdate);
		
		System.out.println("Hi! after the insert service call");
		
//		FileUpdateModel fileUpdate = new FileUpdateModel(fileNmae, extension, modificationDate);
		
		
//		 Optional<EmployeeEntity> employee = repository.findById(entity.getId());
//         
//	        if(employee.isPresent()) 
//	        {
//	            EmployeeEntity newEntity = employee.get();
//	            newEntity.setEmail(entity.getEmail());
//	            newEntity.setFirstName(entity.getFirstName());
//	            newEntity.setLastName(entity.getLastName());
//	 
//	            newEntity = repository.save(newEntity);
//	             
//	            return newEntity;
//	        } else {
//	            entity = repository.save(entity);
//	             
//	            return entity;
//	        }
		
		
		
		
		
		
		
		
		return null;
	}
	
	
	public FileUpdateModel getFileinfoByPath(String filePath)
	{
		
		List<FileUpdateModel> fileUpdateList = fileUpdateDAO.getFileinfoByPath(filePath);
		
		
//		 Optional<EmployeeEntity> employee = repository.findById(entity.getId());
//         
//	        if(employee.isPresent()) 
//	        {
//	            EmployeeEntity newEntity = employee.get();
//	            newEntity.setEmail(entity.getEmail());
//	            newEntity.setFirstName(entity.getFirstName());
//	            newEntity.setLastName(entity.getLastName());
//	 
//	            newEntity = repository.save(newEntity);
//	             
//	            return newEntity;
//	        } else {
//	            entity = repository.save(entity);
//	             
//	            return entity;
//	        }
		
		
		
		
		
		
		
		
		return null;
	}
	
	
	
	

}
