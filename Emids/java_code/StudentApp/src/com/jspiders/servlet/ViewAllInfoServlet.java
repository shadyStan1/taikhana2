package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAllInfoServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		Connection tcon = ConnectionInitiator.createConnection();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		try{
			String query = "select * from students_info ";
			stmt = tcon.createStatement();
			
			
			rs = stmt.executeQuery(query);
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String html = "<html><body><table><tr>"+
							"<th>Sno</th><th>Reg NO</th>"+
							"<th>First Name</th><th>Middle Name</th><th>Last Name</th></tr>";
			int sno = 1;
			while(rs.next()){
				
				html += "<tr>";
				int reg = rs.getInt("regno");
				String firstname = rs.getString("firstname");
				String midname = rs.getString("middlename");
				String lastname = rs.getString("lastname");
				html += "<td>"+ sno + "</td>"+
						"<td>" + reg + "</td>"+
						"<td>" + firstname + "</td>"+
						"<td>" + midname + "</td>"+
						"<td>" + lastname + "</td></tr>";
				sno++;
			}
			html += "</table>"+
					 fname +"<br>" + 
					 lname + "<br>" +
					 "</body></html>";
			
			out.print(html);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			
				try {
					if(tcon!=null)
					tcon.close();
					if(stmt!=null)
						stmt.close();
					
					if(rs!=null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
}
}
