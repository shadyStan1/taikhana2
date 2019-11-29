package com.hbm.inheritence;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class MainClass {
	
	public static void main(String[] args) {
		System.out.println("main started");
		
		Configuration conf = new Configuration().configure("hibernate.cfg1.xml");
		
		SessionFactory sf = conf.buildSessionFactory();
		
		CreditCard cc = new CreditCard();
		cc.setAmount(2435000);
		cc.setCcType("VISA");
		
		Cheque c = new Cheque();
		c.setAmount(5023000);
		c.setChequeType("Cheque");
		
		Session session = sf.openSession();
		
		session.save(cc);
		session.save(c);
		
		Transaction tx = session.beginTransaction();
		
		
//		Session ses = sf.getCurrentSession();
//		ses.save(c);
		
		tx.commit();
		System.out.println("Objects saved");
		
		session.close();
		
	}
}
