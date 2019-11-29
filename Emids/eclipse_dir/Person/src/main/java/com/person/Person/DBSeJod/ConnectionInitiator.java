package com.person.Person.DBSeJod;
import java.io.*;
import java.util.*;
import java.sql.*;
public class ConnectionInitiator {
		private static Connection con = null;
		public static Properties pr = null;
		
		public static Connection createConnection(){
			
		try{
		File f = new File("/home/amanv/db.rpoperties");
		FileReader fr = new FileReader(f);
		pr = new Properties();
		pr.load(fr);
		String dbUrl = pr.getProperty("dburl");
		/*1. Load the Driver and register the driver */
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		/*2. get db connection */
		con = DriverManager.getConnection(dbUrl, pr);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
		}
}
