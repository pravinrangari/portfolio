package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.http.Part;

import com.fileprocessing.FileIOImp;
import com.mysql.cj.jdbc.MysqlDataSource;

public class InsertDaoImp implements InsertDao{

	private String result;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private int row;
	
	@SuppressWarnings("finally")
	@Override
	public String saveMessage(String name, String email, String message) {

		try
		{
			sql="insert into myportfolio.message(name,email,message) values(?,?,?)";
			 con = ConnectionFactory.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setString(1, name);
			 ps.setString(2, email);
			 ps.setString(3, message);
			 row = ps.executeUpdate();
			 if(row==1)
			 {
				 result="saved";
			 }
			
		}
		catch(Exception e)
		{
			System.out.println("InsertDaoImp->saveMessage: "+e);
			result = "exp";

		}
		finally
		{
			return result;
	    }
		
		
	}

	@SuppressWarnings("finally")
	@Override
	public String saveProject(Part part) {
		// TODO Auto-generated method stub
		
		
		try
		{
		    String filename = LocalDateTime.now().toString();
		    String[] split = filename.split(":");
		    String finalfilename = split[0]+split[1]+split[2]+part.getSubmittedFileName();
		    System.out.println(finalfilename+"***");
		    sql="insert into myportfolio.project(filename,date) values(?,?)";
		    con=ConnectionFactory.getConnection();
		    con.setAutoCommit(false);
		    ps=con.prepareStatement(sql);
	    	ps.setString(1, finalfilename);
		    ps.setString(2, LocalDateTime.now().toString());
		    row=ps.executeUpdate();
		    
		    System.out.println(row);
		    if(row==1)
		    	
		    	result = new FileIOImp().uploadProject(part,finalfilename);
		    System.out.println(result);
		    if(result.equals("uploaded"))
		    {
		    	con.commit();
		    	result="saved";
		    }
		    else
		    {
		    	con.rollback();
		    	result="failed";
		    }
		    
		}
		catch(Exception e)
		{
			System.out.println("InsertDaoImp->saveProject"+e);
			result = "exp";
		}
		finally 
		{
		    return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String saveEdu(String year, String title, String subtitle, String description) {
		// TODO Auto-generated method stub
		
		try
		{
			sql="insert into myportfolio.education(year,title,subtitle,description) values(?,?,?,?)";
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, title);
			ps.setString(3, subtitle);
			ps.setString(4, description);
			row=ps.executeUpdate();
			if(row==1)
				result="saved";
		}
		catch(Exception e)
		{
			System.out.println("InsertDaoImp->saveEducation"+e);
			result="exp";
		}
		finally
		{
		    return result;
		}
	}

	
}