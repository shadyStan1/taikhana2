package com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.util.*;
import java.io.*;
import com.mysql.jdbc.Driver;
public class CheckExistence {
public static void main(String[] args) {
	
	Connection con = null;
	//PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	File f = null;
	FileReader fr = null;

		try {
			
			f = new File("/home/user/Downloads/Newgames/New_Journey/src/com/jdbc/db.properties");
			fr = new FileReader(f);
			Properties pr = new Properties();
			pr.load(fr);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//DriverManager.registerDriver(dref);
			
			
			String dbUrl = pr.getProperty("dburl");
			System.out.println(dbUrl);
			con = DriverManager.getConnection(dbUrl, pr);
			
			/*3. Write and execute the Query */
//			String query = "select * from students_other_info where regno = ? and password = ?";
//			pstmt = con.prepareStatement(query);
			
			String query2 = "update students_other_info set password = ? where regno = ?"
				;
			pstmt1 = con.prepareStatement(query2);
			
			//pstmt.setInt(1,Integer.parseInt(args[0]));
//			pstmt.setString(2, args[1]);
			
			pstmt1.setString(1, args[2]);
			pstmt1.setInt(2, Integer.parseInt(args[0]));
			//pstmt1.setString(3, args[1]);
				int count = pstmt1.executeUpdate();
				if(count > 0)
				System.out.println("Success Message " + count);
			
			else
				System.out.println("Error Message");
		}
		 catch (Exception e) {
			 e.printStackTrace();
		}
		finally
		{
			try{
			if(con!=null)
				con.close();
			if(pstmt1!=null)
				con.close();
		}
			catch(Exception e){e.printStackTrace();}
		}		
}
}
