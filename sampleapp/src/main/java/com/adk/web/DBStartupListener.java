package com.adk.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.adk.db.pingpong.CategoryHome;
import com.adk.db.util.SessionFactoryHelper;

/**
 * Application Lifecycle Listener implementation class DBStartupListener
 *
 */
public class DBStartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBStartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	try{
			SessionFactoryHelper.getSessionFactory();
//			CategoryHome.getInstance().createAllCategory();
			System.out.println("Session Factory initialized");
    	}catch(Exception e){
			e.printStackTrace();
		}
    }
	
}
