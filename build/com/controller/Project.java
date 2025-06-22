package com.controller;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.DeleteDaoImp;
import com.dao.InsertDaoImp;

@MultipartConfig
public class Project extends HttpServlet {

	private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		
		if(check.equals("deleteproject"))
		{
			//delete logic
			String filename = request.getParameter("filename");
			result=new DeleteDaoImp().deleteProject(filename);
			if(result.equals("deleted"))
			{
				session.setAttribute("msg", "project deleted successfully");
				response.sendRedirect("deleteproject.jsp");
			}
			else
			{
				session.setAttribute("msg", "something went wrong");
				response.sendRedirect("deleteproject.jsp");
			}
		}
		else if(check.equals("addproject"))
		{
			//add logic
			Part part = request.getPart("file");
			
			//validation
			
			//dao
			
			result = new InsertDaoImp().saveProject(part);
			if(result.equals("saved"))
			{
				session.setAttribute("msg", "project added successfully");
				response.sendRedirect("addproject.jsp");
			}
			else
			{
				session.setAttribute("msg", "something went wrong");
				response.sendRedirect("addproject.jsp");
			}
		}
	}
}
