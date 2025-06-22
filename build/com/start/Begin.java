package com.start;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.dao.CreateDaoImp;


public class Begin implements ServletContextListener {
  public void contextInitialized(ServletContextEvent sce)  { 
         
	  //database and table creation
	  CreateDaoImp c=new CreateDaoImp();
	  c.createDatabase();
	  c.createTable();
    }
	
}
