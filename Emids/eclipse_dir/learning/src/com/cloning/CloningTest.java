package com.cloning;

import java.util.HashMap;
import java.util.Map;

public class CloningTest {
public static void main(String[] args) throws CloneNotSupportedException {
	
	Employee emp = new Employee();
	
	emp.setId(123);
	emp.setName("aman");
	
	Map<String, String> m = new HashMap<>();
	m.put("city", "bangalore");
	m.put("salary", "10000");
	
	emp.setProps(m);
	
	Employee cloneEmp = null;
	try {
		cloneEmp = (Employee) emp.clone();
		
	} 
	catch (CloneNotSupportedException e) {
		e.printStackTrace();
	}
	
	System.out.println("hashcode of emp " + emp.hashCode());
	System.out.println("hashcode of cloneEmp " + cloneEmp.hashCode());
	
	//hashcode equality test performed
	//but will differ
	System.out.println(emp == cloneEmp);
	
	System.out.println(emp.equals(cloneEmp));
	
	System.out.println(emp.getId() == cloneEmp.getId());
	
	System.out.println(emp.getName() == cloneEmp.getName());
	
	//modifying the id
	emp.setId(123344);
	
	System.out.println(emp.getId());
	
	//but cloned one's ID doesn't change
	System.out.println(cloneEmp.getId());
	
	//here it we again clone then ID's will be same
	//cloneEmp = (Employee) emp.clone();
	
	System.out.println(emp.getId() == cloneEmp.getId());
	
	//checking if change inside emp object's string property is reflected in cloned object
	emp.setName("aMaNeM");
	
	System.out.println(emp.getName());
	
	//but cloned one's name doesn't change
	System.out.println(cloneEmp.getName());
	
	System.out.println(emp.getName() == cloneEmp.getName());
	
	//now changing properties of the map in emp object
	
	emp.getProps().put("city", "lucknow");
	
	//results into true as both object point to same MAP object
	System.out.println(emp.getProps() == cloneEmp.getProps());

}
}
