package com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.DriverManager;

import com.mysql.jdbc.Driver;
public class FirstJdbcProgram {
public static void main(String[] args) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	try {
		/*1. Load the Driver*/
//		Driver driveRef = new Driver();
//		DriverManager.registerDriver(driveRef);
		Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.registerDriver(driver);
		/*2. Get the Database Connection */
		String dbUrl = "jdbc:mysql://localhost:3306/BECME_20?user=root&password=root";
		con = DriverManager.getConnection(dbUrl);
		
		/*3. Write and execute the Query */
		String query = "update students_info set firstname = ?, middlename = ?, lastname = ? "
				+ " where regno = ?";
		pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, "kuch");
		pstmt.setString(2, "toh");
		pstmt.setString(3, "hoga");
		pstmt.setInt(4, 5);
		
		int count = pstmt.executeUpdate();
		
		/*4. process the query */
		System.out.println(count);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	/*5. close all driver connections */
	finally{
		try{
		if(con!=null)
			con.close();
		if(pstmt!=null)
			con.close();
	}
		catch(Exception e){e.printStackTrace();}
	}
	
}
}
