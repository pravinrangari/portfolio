package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fileprocessing.FileIOImp;

public class DeleteDaoImp implements DeleteDao {

	private String result;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private int row;
	@SuppressWarnings("finally")
	@Override
	public String deleteMessage(int sn) {
		
		try
		{
			 con = ConnectionFactory.getConnection();
			 sql="delete from myportfolio.message where sn=?";
			 ps=con.prepareStatement(sql);
			 ps.setInt(1, sn);
			 row=ps.executeUpdate();
			 if(row==1) result="deleted";
		}
		catch(Exception e)
		{
			System.out.println("DeleteDaoImp->deleteMessage: "+e);
			result="exp";
		}
		finally
		{
			return result;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public String deleteProject(String filename) {
		try
		{
			 con = ConnectionFactory.getConnection();
			 con.setAutoCommit(false);
			 sql="delete from myportfolio.project where filename=?";
			 ps=con.prepareStatement(sql);
			 ps.setString(1, filename);
			 row=ps.executeUpdate();
			 if(row==1) 
				 result=new FileIOImp().deleteProject(filename);
			 System.out.println(result);
			     if(result.equals("deleted")) {
			    	 con.commit();
			    	 result="deleted";
			     }
			     else {
			    	 con.rollback();
			    	 result="failed";
			     }
		}
		catch(Exception e) {
			System.out.println("DeleteDaoImp->deleteProject: "+e);
			result="exp";
		}
		finally {
			return result;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public String deleteEducation(int sn) {
		try
		{
			 con = ConnectionFactory.getConnection();
			 sql="delete from myportfolio.education where sn=?";
			 ps=con.prepareStatement(sql);
			 ps.setInt(1, sn);
			 row=ps.executeUpdate();
			 if(row==1) result="deleted";
		}
		catch(Exception e)
		{
			System.out.println("DeleteDaoImp->deleteEcuation: "+e);
			result="exp";
		}
		finally
		{
			return result;
		}
	}
}
