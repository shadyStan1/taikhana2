package spring.hibernate.example.SpringHibernateExample.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import spring.hibernate.example.SpringHibernateExample.model.Person;

@Component
public class PersonDAOImpl implements PersonDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.save(p);
	}

	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Person> personList = session.createCriteria(Person.class).list();
		return personList;
	}
	
}
