package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class ViewBasicInfo extends HttpServlet{
	Connection tempCon = null;
	Statement stmt = null;
	ResultSet rs = null;
	PrintWriter out = null;
	protected void doGet(HttpServletRequest req, HttpServletResponse res){
		try {
			tempCon = ConnectionInitiator.createConnection();
			stmt = tempCon.createStatement();
			
			res.setContentType("text/html");
			out = res.getWriter();
			String query = "select * from students_info";
			rs = stmt.executeQuery(query);
			int sno = 1;
			String html = "<!DOCTYPE html>"
						+ " <html>"
						+ "<head>"
						+ "<title>Students Database</title>"
						+ "<style type='text/css'>"
						+ "#container{"
						+	"margin-left: 40px;"
						+	"margin-right: 40px;"
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
						+			"</tr>";
			while(rs.next()){
				int rno = rs.getInt("regno");
				String fname = rs.getString("firstname");
				String mname = rs.getString("middlename");
				String lname = rs.getString("lastname");
				  html +=   "<tr>"
						+ "<td>"+ sno +"</td>"
						+ "<td>"
						+ "<a href=http://localhost:8080/StudentApp/studentscompletedetails?regno="+rno+">"
						+ rno +"</a></td>"																					
						+ "<td>"+ fname +"</td>"
						+ "<td>"+ mname +"</td>"
						+ "<td>"+ lname +"</td>"
						+ "</tr>";
				sno++;
			}
			html += "</table></div></body>"
					+ "</html>";
			
			out.print(html);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
				try {
					if(tempCon!= null)
					tempCon.close();
					
					if(stmt!= null)
						stmt.close();
					
					if(rs!= null)
						rs.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
