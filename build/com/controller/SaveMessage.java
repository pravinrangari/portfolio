package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.InsertDaoImp;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.validation.validation;
public class SaveMessage extends HttpServlet {
	private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String name = request.getParameter("name");
		  String email = request.getParameter("email");
		  String message = request.getParameter("message");
		  //checkpoint1 sysout->name email message RUN
		  System.out.println(name+" "+email+" "+message);
		  result = new validation().validateMessage(name, email, message);
		  //checkpoint2 sysout->result
		  
		  System.out.println(result);
		  HttpSession session = request.getSession();
		  
		  if(result.equals("valid"))
		  {
			  //DAO
			  result= new InsertDaoImp().saveMessage(name, email, message);
			  System.out.println(result);
			  if(result.equals("saved")) {
				  
				  session.setAttribute("msg", "message sent successfully");
				  response.sendRedirect("index.jsp");
			  }
			  else {
				  session.setAttribute("msg", "something went wrong");
				  response.sendRedirect("index.jsp");
			  }
		  }
		  else
		  {
			  session.setAttribute("msg",result);
			  response.sendRedirect("index.jsp");
		  }
   	 }
}
