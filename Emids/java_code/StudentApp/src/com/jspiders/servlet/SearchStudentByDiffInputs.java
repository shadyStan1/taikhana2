package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudentByDiffInputs extends HttpServlet{
	Connection tcon = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PrintWriter out = null;
	int sno = 1;
	int regisNo;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//Receiving values via httpRequest
	String rno = req.getParameter("regno");
	
	if(rno.isEmpty() == false){
	regisNo = Integer.parseInt(rno);}
	String stufname = req.getParameter("fname");
	String stumname = req.getParameter("mname");
	String stulname = req.getParameter("lname");
	String guarfname = req.getParameter("guarfirname");
	String guarlname = req.getParameter("guarlastname");
	//end receiving
	
	//designing query filtering through view table
	String query1 = "select * from Filter_Students where regno = ? "
					+ " or firstname = ? " 
					+ " or middlename = ?"
					+ " or lastname = ?"  
					+ " or guardian_first_name = ? " 
					+ " or guardian_last_name = ?" ;
	
	try{
		resp.setContentType("text/html");
		out = resp.getWriter();
		tcon = ConnectionInitiator.createConnection();
		pstmt = tcon.prepareStatement(query1);
		
		/*checking values if they are empty
		 * if they are empty
		 * setting them to null
		 */
		if(rno.isEmpty() == false)
			pstmt.setInt(1, regisNo);
		else
			pstmt.setString(1,null);
		
		if("".equals(stufname)){
			stufname=null;
		}
		if("".equals(stumname)){
			stumname=null;
		}
		if("".equals(stulname)){
			stulname=null;
		}
		if("".equals(guarfname)){
			guarfname=null;
		}
		if("".equals(guarlname)){
			guarlname=null;
		}
		
		pstmt.setString(2, stufname);
		pstmt.setString(3, stumname);
		pstmt.setString(4, stulname);
		pstmt.setString(5, guarfname);
		pstmt.setString(6, guarlname);
		
		//firing the query and getting the result
		rs = pstmt.executeQuery();
		
		//System.out.println(pstmt.toString());//this will print the complete the final query
		
		//designing the html response
		String html = "<!DOCTYPE html>"
				+ " <html>"
				+ "<head>"
				+ "<title>Students Database</title>"
				+ "<style type='text/css'>"
				+ "#container{"
				+	"margin-left: 40px;"
				+  "}"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+	"<div id='container'>"
				+		"<table>"
				+			"<tr>"
				+				"<th>Sno</th>"
				+				"<th>Reg No</th>"
				+				"<th>First Name</th>"
				+				"<th>Middle Name</th>"
				+				"<th>Last Name</th>"
				+				"<th>Guardian First Name</th>"
				+				"<th>Guardian Last Name</th>"
				+			"</tr>";
		//fetching the result
		while(rs.next()){
			html+= 		"<tr>"
						+ "<td>"
						+ sno
						+ "</td>"
						+ "<td>"
						+ rs.getString("regno")
						+ "</td>"
						+ "<td>"
						+ rs.getString("firstname")
						+ "</td>"
						+ "<td>"
						+ rs.getString("middlename")
						+ "</td>"
						+ "<td>"
						+ rs.getString("lastname")
						+ "</td>"
						+ "<td>"
						+ rs.getString("guardian_first_name")
						+ "</td>"
						+ "<td>"
						+ rs.getString("guardian_last_name")
						+ "</td>"
						+ "</tr>";
			sno++;
		}
		html+= "</table></body></html>";
		out.print(html);
	}
	
	catch(Exception e){
		e.printStackTrace();
	}
	
	finally{
		try {
			if(tcon!= null)
			tcon.close();
			
			if(pstmt!= null)
				pstmt.close();
			
			if(rs!= null)
				rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
}
