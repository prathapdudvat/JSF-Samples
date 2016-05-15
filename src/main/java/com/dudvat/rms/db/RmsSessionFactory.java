package com.dudvat.rms.db;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class RmsSessionFactory{
	
	 private static final SessionFactory sessionFactory = buildSessionFactory();
	  
		private static SessionFactory buildSessionFactory() {
	        try {
	        	  AnnotationConfiguration configuration=new AnnotationConfiguration();  
	        	   configuration.configure("hibernate.cfg.xml");  
	            return configuration.buildSessionFactory(); 
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	  
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	  
	    public static void shutdown() {
	        getSessionFactory().close();
	    }
}