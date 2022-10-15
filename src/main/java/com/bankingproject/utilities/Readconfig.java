package com.bankingproject.utilities;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
public class Readconfig {
	
	Properties pro;
	
	public Readconfig() {
		 File src = new File("C:\\Users\\swati\\eclipse-workspace\\mavenproject\\Configuration\\config.properties");
		 
		 FileInputStream file;
		 
		 try {
			 pro = new Properties();
			 file = new FileInputStream(src);
			 pro.load(file);
			 			 		 }
		
		catch(Exception e) {
			System.out.println("Exception is:"+e.getMessage());
				}
			}
	
	public String getApplicationURL() {
		
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserID() {
		String UserID = pro.getProperty("UserID");
		return UserID;}
		
		public String getPassword() {
			String Password = pro.getProperty("Password");
			return Password;
		
	}
	

}
