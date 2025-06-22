package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.el.util.Validation;

import com.fileprocessing.FileIOImp;
import com.validation.validation;

@MultipartConfig
public class Resume extends HttpServlet {
	
	private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		
		if(check.equals("uploadresume"))
		{
			//upload resume logic
			Part part = request.getPart("resume");
			
			//validation
			result=new validation().validateResume(part);
			
			if(result.equals("valid"))
			{  
				result = new FileIOImp().uploadResume(part);
				if (result.equals("uploaded")) {
					session.setAttribute("msg", "resume uploaded successfully");
					response.sendRedirect("uploadresume.jsp");
				} else {
					session.setAttribute("msg", "something went wrong");
					response.sendRedirect("uploadresume.jsp");
				}
			}
			else
			{
				session.setAttribute("msg", result);
				response.sendRedirect("uploadresume.jsp");
			}
		}
		else if(check.equals("downloadresume"))
		{
			//download resume 
			FileIOImp f=new FileIOImp();   
			byte[] b = f.downloadResume();
		    String fileName = f.getFileName();
			ServletOutputStream os = response.getOutputStream();
			
			response.setHeader("content-disposition","filename="+fileName);
			response.setContentType("application/octet-stream");
			
			os.write(b);
			os.close();  
			
		}
	}
}
