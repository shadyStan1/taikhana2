package com.jdbc;
import java.sql.*;
import java.io.*;
public class ReadCsvFileDemo{

 public static void main(String[] args) throws Exception{
	 Connection tcon = ConnectionInitiator.createConnection();
	 
	 PreparedStatement pstmt1 = null;
	 PreparedStatement pstmt2 = null;
	 PreparedStatement pstmt3 = null;
	 /*create queries prototype*/
	 String q1 = "insert into students_info values(?,?,?,?)";
	 String q2 = "insert into students_other_info values(?,?,?)";
	 String q3 = "insert into students_guardians_info values(?,?,?)";
	 
	 
	 /*create executable queries template*/
	 pstmt1 = tcon.prepareStatement(q1);
	 pstmt2 = tcon.prepareStatement(q2);
	 pstmt3 = tcon.prepareStatement(q3);
	 
	 
	/*connection to a csv file*/ 
	File f = new File("/home/user/Downloads/CodingOnNotepad/CSVExample.csv");
	FileReader fr = new FileReader(f);
	
	/*reading the data in csv file */
	BufferedReader br = new BufferedReader(fr);
	String s = br.readLine();
	
	while(s!=null){
		String[] str = s.split("\\,");
		
		
		/*insertion into tables*/
		//1.into students_info

		pstmt1.setInt(1,Integer.parseInt(str[0]));pstmt1.setString(2, str[1]);
		pstmt1.setString(3, str[2]);
		pstmt1.setString(4, str[3]);
		
		//2.into students_other_info
		pstmt2.setInt(1,Integer.parseInt(str[0]));pstmt2.setString(2, str[6]);
		pstmt2.setString(3, str[7]);

		//3.into students_guardians_info
		pstmt3.setInt(1,Integer.parseInt(str[0]));pstmt3.setString(2, str[4]);
		pstmt3.setString(3, str[5]);
		
		int c1 = pstmt1.executeUpdate();
		int c2 = pstmt2.executeUpdate();
		int c3 = pstmt3.executeUpdate();
		
		System.out.println(c1 + "  " + c2 + "   "+ c3);
		//end insertion
		s = br.readLine();
	}
}

}
