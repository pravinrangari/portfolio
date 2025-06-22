package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ReadDaoImp;
public class AdminLogin extends HttpServlet {
	
    private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		result= new ReadDaoImp().readAdminLogin(username, password);
		
		HttpSession session = request.getSession();
		if(result.equals("exist"))
		{
			session.setAttribute("login", "exits");
			response.sendRedirect("adminpanel.jsp");
		}
		else
		{
			session.setAttribute("msg", "invalid id or pass");
			response.sendRedirect("adminlogin.jsp");
		}
		
		
		
	}

}
