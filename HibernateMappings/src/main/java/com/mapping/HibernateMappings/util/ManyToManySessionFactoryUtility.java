package com.mapping.HibernateMappings.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ManyToManySessionFactoryUtility {

		private static SessionFactory sessionFactory;
		
		private static SessionFactory buildSessionFactory()
		{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			System.out.println("loaded config file");
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).build();
			
			System.out.println("Session factory Registry build");
			
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			System.out.println("session factory build");
			
			return sessionFactory;
			
		}
		
		public static SessionFactory getSessionFactory()
		{
			if(sessionFactory == null) return buildSessionFactory();
			
			return sessionFactory;
		}
	
}
