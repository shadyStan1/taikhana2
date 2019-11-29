package spring.hibernate.example.SpringHibernateExample.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import spring.hibernate.example.SpringHibernateExample.dao.PersonDAO;
import spring.hibernate.example.SpringHibernateExample.dao.PersonDAOImpl;
import spring.hibernate.example.SpringHibernateExample.model.Person;

@Service
public class SpringHibernateTest {

	
	private PersonDAOImpl personDAO;
	
	@Autowired
	public void setPersonDao(PersonDAOImpl personDAO)
	{
		this.personDAO=personDAO;
	}
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		
		//PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
		SpringHibernateTest test=new SpringHibernateTest();
		test.m();
//		
//		List<Person> list = personDAO.list();
		
//		for(Person p : list){
//			System.out.println("Person List::"+p);
//		}
		//close resources
		context.close();	
	}
	
	public void m()
	{
		Person person = new Person();
		person.setName("aMaNeM"); person.setCountry("India");
		
		personDAO.save(person);
	}
}
