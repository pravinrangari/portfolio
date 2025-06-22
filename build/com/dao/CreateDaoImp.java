package com.dao;

import java.sql.Connection;
import java.sql.Statement;

public class CreateDaoImp implements CreateDao {
	


@Override
public void createDatabase() {
	// TODO Auto-generated method stub
	try {
		Connection con=ConnectionFactory.getConnection();
		Statement s=con.createStatement();
		String sql="create database portfolio";
		s.execute(sql);
		System.out.println("database created");
	}catch(Exception e) {
		System.out.println("Create->createDatabase:"+e);;
		}
}

@Override
public void createTable() {
	// TODO Auto-generated method stub
	try {
		Connection con=ConnectionFactory.getConnection();
		Statement s=con.createStatement();
		String sql ="create table my_portfolio.message("
				+"sn int primary key auto_increment,"
		        +"name varchar(30),"
			    +"email varchar(20),"
		        +"message varchar(200))";
		    s.execute(sql);//ddl
		System.out.println("table created");
	}catch(Exception e) {
		System.out.println("Create->createTable:"+e);
	}

		
	}
	
}


