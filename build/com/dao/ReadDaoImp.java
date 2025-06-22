package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.EducationPojo;
import com.model.MessagePojo;
import com.model.ProjectPojo;
public class ReadDaoImp implements ReadDao {

	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String result;
	
	@SuppressWarnings("finally")
	@Override
	public ArrayList<MessagePojo> readMessage() {
		
		ArrayList<MessagePojo> arrayList = new ArrayList<>();
		try {
			 sql="SELECT * FROM my_portfolio";
			 con = ConnectionFactory.getConnection();
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
		   	while(rs.next())
			{
				int getsn=rs.getInt("sn");
				String getname=rs.getString("name");
				String getemail=rs.getString("email");
				String getmessage=rs.getString("message");
				
				MessagePojo messagePojo = new MessagePojo(getsn, getname, getemail, getmessage);
				arrayList.add(messagePojo);
			}
		}
		catch(Exception e) {
			System.out.println("ReadDaoImp->readMessage:"+e);
		}
		finally {
			
			return arrayList;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String readAdminLogin(String username, String password) {
		try {
			 sql="SELECT * FROM my_portfolio.adminlogin where username=? and password=?";
			 con = ConnectionFactory.getConnection();
			 ps = con.prepareStatement(sql);
			 ps.setString(1, username);
			 ps.setString(2, password);
			 rs = ps.executeQuery();
			 boolean next = rs.next();
			 if(next==true){
				 result="exist";
			 }
			 else {
				 result="notexist";
			 } 
		}
		catch(Exception e) {
			System.out.println("ReadDaoImp->readAdminLogin:"+e);
			result="exp";
		}
		finally {
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<ProjectPojo> readProject() {
		ArrayList<ProjectPojo> arrayList = new ArrayList<>();
		try {
			 sql="SELECT * FROM my_portfolio";
			 con = ConnectionFactory.getConnection();
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
		   	while(rs.next())
			{
				int sn=rs.getInt("sn");
				String filename=rs.getString("filename");
				String date=rs.getString("date");
				
				ProjectPojo p = new ProjectPojo(sn, filename, date);
				arrayList.add(p);
			}
		}
		catch(Exception e) {
			System.out.println("ReadDaoImp->readMessage:"+e);
		}
		finally {
			
			return arrayList;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<EducationPojo> readEducation() {
		ArrayList<EducationPojo> arrayList = new ArrayList<>();
		try {
			 sql="SELECT * FROM.education";
			 con = ConnectionFactory.getConnection();
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
		   	while(rs.next())
			{
				arrayList.add(new EducationPojo(rs.getInt("sn"), rs.getString("year"), rs.getString("title"),rs.getString("subtitle"),rs.getString("description")));
			}
		}
		catch(Exception e) {
			System.out.println("ReadDaoImp->readproject:"+e);
		}
		finally {
			
			return arrayList;
		}
	}
}