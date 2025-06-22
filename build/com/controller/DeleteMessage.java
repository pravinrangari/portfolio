package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteDaoImp;
public class DeleteMessage extends HttpServlet {
	private String result ;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sn = request.getParameter("sn");
		result= new DeleteDaoImp().deleteMessage(Integer.parseInt(sn));
		HttpSession session = request.getSession();
		if(result.equals("deleted"))
		{
			session.setAttribute("msg", "message deleted successfully");
			response.sendRedirect("readmessage.jsp");
		}
		else
		{
			session.setAttribute("msg", "something went wrong");
			response.sendRedirect("readmessage.jsp");
		}
		
	}
}
