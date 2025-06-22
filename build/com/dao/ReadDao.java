package com.dao;
import java.util.ArrayList;

import com.model.EducationPojo;
import com.model.MessagePojo;
import com.model.ProjectPojo;

public interface ReadDao {

	public ArrayList<MessagePojo> readMessage();
	public String readAdminLogin(String username,String password);
	public ArrayList<ProjectPojo> readProject();
	public ArrayList<EducationPojo> readEducation();

	
	
}
