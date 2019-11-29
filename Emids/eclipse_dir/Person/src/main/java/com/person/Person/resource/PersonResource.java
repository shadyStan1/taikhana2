package com.person.Person.resource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.person.Person.DBSeJod.ConnectionInitiator;
import com.person.Person.Entities.Person;

@Path("/getPeople")
public class PersonResource {
	
	Connection tcon = null;
	Statement pstmt = null;
	ResultSet rs = null;
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/getAllPeople")
	public Person[] getPeople() throws SQLException
	{
		System.out.println("shbfhebf");
		return null;
//		tcon = ConnectionInitiator.createConnection();
//		String sql = "select * from person";
//	    pstmt = tcon.createStatement();
//	    
//	    rs = pstmt.executeQuery(sql);
//	    List rowValues  = new ArrayList<>();
//	    while(rs.next())
//	    {
//	    	rowValues.add(new Person(rs.getLong(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
//	    }
//	    
//	    Person[] personArr = (Person[]) rowValues.toArray();
//	    return personArr;
	}

}
