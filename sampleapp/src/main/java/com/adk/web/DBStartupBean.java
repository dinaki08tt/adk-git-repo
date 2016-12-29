package com.adk.web;

import org.springframework.context.annotation.*;

import com.adk.db.pingpong.AuthoritiesHome;
import com.adk.db.pingpong.CategoryHome;
import com.adk.db.pingpong.UsersHome;
import com.adk.db.util.SessionFactoryHelper;
	
@Configuration
public class DBStartupBean {
	
	@Bean(initMethod = "init", destroyMethod = "cleanup" )
	public DBStartupBean getBean() {
	      return new DBStartupBean();
	}
	
	public void init(){
    	try{
			SessionFactoryHelper.getSessionFactory();
//			CategoryHome.getInstance().createAllCategory();
			UsersHome udao = UsersHome.getInstance();
			AuthoritiesHome adao = AuthoritiesHome.getInstance();
			CategoryHome cdao =CategoryHome.getInstance();
			if(!udao.isInitialLoaded()){
				udao.loadInitialUsers();
				adao.loadInitialRoles();
			}if(!cdao.isInitialLoaded()){
				cdao.createAllCategory();
			}
			System.out.println("Session Factory initialized");
    	}catch(Exception e){
			e.printStackTrace();
		}
 
	}
	
	public void cleanup(){
		System.out.println("closing the bean");
	}
}
