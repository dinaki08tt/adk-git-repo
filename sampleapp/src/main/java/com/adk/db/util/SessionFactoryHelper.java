package com.adk.db.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class SessionFactoryHelper {
	private static SessionFactory sessionFactory = null; 
//	private final static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
				sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
	}
}
