package com.mapping.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mapping.HibernateMappings.model.CartManyToManyAnnotationWithItems;
import com.mapping.HibernateMappings.model.ItemsManyToManyAnnotationToCart;
import com.mapping.HibernateMappings.util.HibernateUtil;

public class CartManyToManyAnnotationWithItemsRunner {

	public static void main(String[] args) {
		
		Set<ItemsManyToManyAnnotationToCart> items1 = new HashSet<>();
		ItemsManyToManyAnnotationToCart nokiaN72 = new ItemsManyToManyAnnotationToCart();
		nokiaN72.setItem_desc("N series item");nokiaN72.setItem_price(20000);
		
		ItemsManyToManyAnnotationToCart nokiaE63 = new ItemsManyToManyAnnotationToCart();
		nokiaE63.setItem_desc("E series item" );nokiaE63.setItem_price(30000);
		
		items1.add(nokiaE63);items1.add(nokiaN72);
		
		CartManyToManyAnnotationWithItems cart1 = new CartManyToManyAnnotationWithItems();
		cart1.setTotal(500);cart1.setItems(items1);
		
		CartManyToManyAnnotationWithItems cart2 = new CartManyToManyAnnotationWithItems();
		cart2.setTotal(1000);cart2.setItems(items1);
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(cart1);
		session.save(cart2);
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
