package com.mapping.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.HibernateMappings.model.CartManyToManyAnnotation;
import com.mapping.HibernateMappings.model.ItemsManyToManyAnnotation;
import com.mapping.HibernateMappings.util.HibernateUtil;

public class ManyToManyAnnotationsRunner {

	public static void main(String[] args) {
		//Saving many-to-many where Cart is primary

		ItemsManyToManyAnnotation mac = new ItemsManyToManyAnnotation();
		mac.setItemPrice(100); mac.setItemDesc("mac");
		
		ItemsManyToManyAnnotation macAir = new ItemsManyToManyAnnotation();
		macAir.setItemPrice(50); macAir.setItemDesc("macAir");
		
//		Set<ItemsManyToManyAnnotation> items = new HashSet<ItemsManyToManyAnnotation>();
//		items.add(iphone); items.add(ipod);
//		
		CartManyToManyAnnotation amazonCart = new CartManyToManyAnnotation();
		amazonCart.setTotal(150);
		
		CartManyToManyAnnotation flipkartCart1 = new CartManyToManyAnnotation();
		flipkartCart1.setTotal(150);
		
		Set<CartManyToManyAnnotation> carts = new HashSet<CartManyToManyAnnotation>();
		carts.add(amazonCart);carts.add(flipkartCart1);
		
		Set<CartManyToManyAnnotation> carts1 = new HashSet<CartManyToManyAnnotation>();
		carts.add(flipkartCart1);
		
		mac.setCarts(carts);macAir.setCarts(carts1);
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(mac);
		session.save(macAir);
		System.out.println("Before committing transaction");
		tx.commit();
		sessionFactory.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
}
