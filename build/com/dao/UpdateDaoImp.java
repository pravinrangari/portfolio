package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDaoImp implements UpdateDao{

	private String result;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private int row;
	@SuppressWarnings("finally")
	@Override
	public String updateEducation(int sn, String year, String title, String subtitle, String description) {
		// TODO Auto-generated method stub
		
		try
		{
			sql="update myportfolio.education set year=?,title=?,subtitle=?,description=? where sn=?";
			con=ConnectionFactory.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, year);
			ps.setString(2, title);
			ps.setString(3, subtitle);
			ps.setString(4, description);
			ps.setInt(5, sn);
			
			row=ps.executeUpdate();
			if(row==1) result="updated";
		}
		catch(Exception e)
		{
			System.out.println("UpdateDaoImp:-updateEducation"+e);
			result="exp";
		}
		finally {
			return result;
		}
	}

}