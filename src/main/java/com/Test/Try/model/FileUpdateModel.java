//package io.nayandip.filereadwriteservice.model;
package com.Test.Try.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name="FILEUPDATE")
public class FileUpdateModel {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	private Integer id;
	
	private String fileName;
//	private String filePath;
	private Long fileSize;
	private Integer numberOfLine;
	private String extension;
	private Timestamp modificationDate;
	
	
	
	
	public FileUpdateModel() {

	}



	public FileUpdateModel(String fileName, Long fileSize, Integer numberOfLine, String extension,
			Timestamp modificationDate) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.numberOfLine = numberOfLine;
		this.extension = extension;
		this.modificationDate = modificationDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




	public String getFileName() {
		return fileName;
	}




	public void setFileName(String fileName) {
		this.fileName = fileName;
	}




	public Long getFileSize() {
		return fileSize;
	}




	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}




	public Integer getNumberOfLine() {
		return numberOfLine;
	}




	public void setNumberOfLine(Integer numberOfLine) {
		this.numberOfLine = numberOfLine;
	}




	public String getExtension() {
		return extension;
	}




	public void setExtension(String extension) {
		this.extension = extension;
	}




	public Timestamp getModificationDate() {
		return modificationDate;
	}




	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}



	
	
}
