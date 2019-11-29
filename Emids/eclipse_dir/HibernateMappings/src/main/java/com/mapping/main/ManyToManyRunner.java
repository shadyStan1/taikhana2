package com.mapping.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.HibernateMappings.model.Cart1;
import com.mapping.HibernateMappings.model.Items1;
import com.mapping.HibernateMappings.util.ManyToManySessionFactoryUtility;

public class ManyToManyRunner {

	public static void main(String[] args) {
		//Saving many-to-many where Cart is primary

		Items1 iphone = new Items1();
		iphone.setItemPrice(100); iphone.setItemDesc("iPhone");
		
		Items1 ipod = new Items1();
		ipod.setItemPrice(50); ipod.setItemDesc("iPod");
		
		Set<Items1> items = new HashSet<Items1>();
		items.add(iphone); items.add(ipod);
		
		Cart1 cart = new Cart1();
		cart.setItems(items);
		cart.setTotal(150);
		
		Cart1 cart1 = new Cart1();
		Set<Items1> items1 = new HashSet<Items1>();
		items1.add(iphone);
		cart1.setItems(items1);
		cart1.setTotal(100);
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = ManyToManySessionFactoryUtility.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(cart);
		session.save(cart1);
		System.out.println("Before committing transaction");
		tx.commit();
		sessionFactory.close();
		
		System.out.println("Cart ID="+cart.getId());
		System.out.println("Cart1 ID="+cart1.getId());
		System.out.println("Item1 ID="+iphone.getId());
		System.out.println("Item2 ID="+ipod.getId());
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
		
		
	}
}
