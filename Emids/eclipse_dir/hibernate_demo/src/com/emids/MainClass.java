package com.emids;

import org.hibernate.cfg.Configuration;
import org.hibernate.*;

public class MainClass {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration().configure();
			
		SessionFactory sf = conf.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Employee emp = new Employee();
		emp.setEmpEmail("aman@dhoka.com");
		emp.setEmpId(10);
		emp.setEmpName("amanem");
		
		Transaction tx = session.beginTransaction();
		session.save(emp);
		
		tx.commit();
		
		sf.close();
		
	}
}
