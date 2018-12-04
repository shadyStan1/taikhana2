package spring.hibernate.example.SpringHibernateExample.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.hibernate.example.SpringHibernateExample.dao.PersonDAO;
import spring.hibernate.example.SpringHibernateExample.model.Person;

public class SpringHibernateTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		
		PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
		
		Person person = new Person();
		person.setName("aMaNeM"); person.setCountry("India");
		
		personDAO.save(person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		//close resources
		context.close();	
	}
}
