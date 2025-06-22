package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DeleteDaoImp;
import com.dao.InsertDaoImp;
import com.dao.UpdateDaoImp;
public class Education extends HttpServlet {
	
	private String result;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		if(check.equals("addedu"))
		{
			//Add Education logic
			
			String year = request.getParameter("year");
			String title = request.getParameter("title");
			String subtitle = request.getParameter("subtitle");
			String description = request.getParameter("description");
			
			//Validation
			
			result = new InsertDaoImp().saveEdu(year, title, subtitle, description);
			if(result.equals("saved"))
			{
				session.setAttribute("msg", "education added successfully");
				response.sendRedirect("addedu.jsp");
			}
			else
			{
				session.setAttribute("msg", "something went wrong");
				response.sendRedirect("addedu.jsp");
			}
		}
		else if(check.equals("deleteedu"))
		{
			//delete edcuation logic
			String sn = request.getParameter("sn");
			result=new DeleteDaoImp().deleteEducation(Integer.parseInt(sn));
			if(result.equals("deleted"))
			{
				session.setAttribute("msg", "education deleted successfully");
				response.sendRedirect("readedu.jsp");
			}
			else
			{
				session.setAttribute("msg", "something went wrong");
				response.sendRedirect("readedu.jsp");
			}
		}
		else if(check.equals("updateedu"))
		{
			//update logic
			String sn= request.getParameter("sn");
			String year = request.getParameter("year");
			String title = request.getParameter("title");
			String subtitle = request.getParameter("subtitle");
			String description = request.getParameter("description");
			
			result = new UpdateDaoImp().updateEducation(Integer.parseInt(sn), year, title, subtitle, description);
			if(result.equals("updated"))
			{
				session.setAttribute("msg", "education updated successfully");
				response.sendRedirect("readedu.jsp");
			}
			else
			{
				session.setAttribute("msg", "something went wrong");
				response.sendRedirect("readedu.jsp");
			}
		}
	}

}
