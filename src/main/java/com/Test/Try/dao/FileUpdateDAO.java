//package io.nayandip.filereadwriteservice.dao;
package com.Test.Try.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import io.nayandip.filereadwriteservice.model.FileUpdateModel;

import com.Test.Try.model.FileUpdateModel;


@Repository
public class FileUpdateDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	
	public void addFileUpdate(FileUpdateModel fileUpdate)
	{
		Session session = entityManager.unwrap(Session.class);
		session.save(fileUpdate);
		
		
	}
	
	public void addOrUpdateFileUpdate(FileUpdateModel fileUpdate)
	{
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(fileUpdate);
		
		
	}
	
	public List<FileUpdateModel> getFileinfoByPath(String filePath)
	{
//		Session session = entityManager.unwrap(Session.class);
//		
//		return session.get(FileUpdateModel.class,filePath);
		
		Session session = entityManager.unwrap(Session.class);
		Query<FileUpdateModel> query = session.createQuery("from FileUpdateModel  fum where fum.path =:arg");
		query.setParameter("arg", filePath);
		List<FileUpdateModel> bookList =query.getResultList();
		
		return bookList;
	}
	

}
