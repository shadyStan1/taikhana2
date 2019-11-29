package com.mapping.HibernateMappings.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory()
	{
		try
		{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate-annotations.xml");
		System.out.println("Hibernate Configuration loaded");
	
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
				.build();
		System.out.println("Hibernate serviceRegistry created");
		
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		}
		
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null) return buildSessionFactory();
		return sessionFactory;
	}
	
	
	
}
