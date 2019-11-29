package spring.hibernate.example.SpringHibernateExample.dao;

import java.util.List;

import spring.hibernate.example.SpringHibernateExample.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
