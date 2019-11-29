package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;
public class CallableStatementDemo {

	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		CallableStatement cs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BECME_20?user=root&password=root");
			
			//String query = "CALL getStudent() ";
					String	query = 	 "call ekAurBe()";
			
			cs = con.prepareCall(query);
			
			boolean isDBResult = cs.execute();
			
			if(isDBResult){
				
				rs = cs.getResultSet();
				while(rs.next()){
					
					int rno = rs.getInt("regno");
					String fn = rs.getString("firstname");
					String mn = rs.getString("middlename");
					String ln = rs.getString("lastname");
					System.out.println(rno + " " + fn + " "+mn + " "+ln);
				}
			}
			else{
				System.out.println(cs.getUpdateCount());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
