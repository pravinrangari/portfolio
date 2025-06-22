package com.dao;

import javax.servlet.http.Part;

public interface InsertDao {
	
	public String saveMessage(String name,String email,String message);
	public String saveProject(Part part);
	public String saveEdu(String year,String title, String subtitle,String description);


}
