package com.Test.Try.controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Test.Try.model.FileUpdateModel;
import com.Test.Try.service.FileUpdateService;

@Controller
public class TestController {
	
	
	@Autowired
	FileUpdateService fileService;
	
	

	@RequestMapping("/")
	public String showWelcomePage()
	{
		
		return "welcome";
	}
	
	
	
	   @RequestMapping(value="/", method = RequestMethod.POST, params = "fetch")
	    public String fetchFileData(ModelMap model, @RequestParam String path, @RequestParam String fileContent){

		   System.out.println("Hay!!! I am in post method");
		   
		   System.out.println("path : " + path);
		   
		   System.out.println("fileContent : "+ fileContent);
		   
		   
//		   fileContent="I am here to show the file contents";
		   
		   
//		   boolean isValidUser = service.validateUser(name, password);
//
//	        if (!isValidUser) {
//	            model.put("errorMessage", "Invalid Credentials");
//	            return "login";
//	        }
//
		   fileContent = fileReader(path);
		   
	        model.put("path", path);
	        model.put("fileContent", fileContent);

	        return "welcome";
	    }
	   
	   
	   @RequestMapping(value="/", method = RequestMethod.POST, params = "save")
	    public String saveFileData(ModelMap model, @RequestParam String path, @RequestParam String fileContent){

		   System.out.println("Hay!!! I am in post method");
		   
		   System.out.println("path : " + path);
		   
		   System.out.println("fileContent : "+ fileContent);
		   
		   
	        if (fileContent==null || fileContent.length()==0) {
	            
	        	
	        	System.out.println("I am in error section");
	        	
	        	model.put("errorMessage", "File Content can not be blank.");
	            model.put("path", path);
		        model.put("fileContent", fileContent);
		        
		        return "welcome";
	        }
		   
		   
//		   boolean isValidUser = service.validateUser(name, password);
//
//	        if (!isValidUser) {
//	            model.put("errorMessage", "Invalid Credentials");
//	            return "login";
//	        }
//
		   
		   
		   writeToFile(path, fileContent);
		   
		   
	        model.put("path", path);
	        model.put("fileContent", fileContent);

	     
	        
	        return "welcome";
	    }
	   
	
	   
		public String fileReader(String path)
		{
//			InputStream in = getClass().getResourceAsStream("/home/nayandip/spring-boot-project/test.txt");
			
//			InputStream in = FilterReader.class.getResourceAsStream("/home/nayandip/Desktop/TestDoc");
			int lineNumber=0;
			String content = new String();
			
			try {
//			    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				
//				path = "/home/nayandip/Desktop/TestDoc";
//				path = "/home/nayandip/spring-boot-project/test.txt";
				
				System.out.println("path : "+ path);
				
				
				
				BufferedReader reader = new BufferedReader(new FileReader(path));
				String line = null;
			        while ((line = reader.readLine()) != null) {
			        	lineNumber++;
			            System.out.println(line);
			            content=content+line;
			        }
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			System.out.println("Number of line at the file  : "+ lineNumber);
			
			return content;
		}
		
		

		
		
		public File writeToFile(String path, String fileContent)
		{
			
			System.out.println("File input : " + fileContent);
			
			FileWriter writer = null;
			
			try {
//			    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				
//				path = "/home/nayandip/Desktop/TestDoc";
//				path = "/home/nayandip/spring-boot-project/test1.txt";
				
				
				
				writer = new FileWriter(path);
				
				writer.write(fileContent);
				
				
				
				
			}catch (Exception e) {
			    e.printStackTrace();
			}finally
			{
				if(writer != null)
				{
					
					try
					{
						writer.flush();
						writer.close();
					}catch (Exception e) {
					    e.printStackTrace();
					}
					
				}
				
			}
			
		
			File file = new File(path);
			long fileSize = file.length();
			String fileName = file.getName();
			String extension = "";  
			int lineCount=0;
	        int i = fileName.lastIndexOf('.');  

	        if (i > 0)   
	        {  
	            extension = fileName.substring(i + 1);  
	        }  
			
			System.out.println("fileSize : " + fileSize);
			System.out.println("fileNmae : "+ fileName);
			System.out.println("extension : "+ extension);
			
		    try
		    {
				Scanner sc = new Scanner(file);
		
			      // read each line and
			      // count number of lines
			      while(sc.hasNextLine()) {
			        sc.nextLine();
			        lineCount++;
			      }
			      
		
			      // close scanner
			      sc.close();
	        
		    } catch (Exception e) {
		        e.getStackTrace();
		    }
		    
		    System.out.println("Total Number of Lines: " + lineCount);
		    
		    Timestamp modificationDate = Timestamp.from(Instant.now());;
		    
		    FileUpdateModel fileUpdateModel = new FileUpdateModel(fileName, fileSize, lineCount, extension,	modificationDate);
		    							
		    
		    fileService.addFileinfo(fileUpdateModel);
		    
		    
//			Timestamp modificationDate;
			
//			FileUpdateModel fileUpdate=	fileService.addOrUpdateFileinfo(fileNmae, extension, modificationDate);
			
			
			return file;
		}
		

	
	
}
