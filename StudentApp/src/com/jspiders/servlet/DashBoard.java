package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DashBoard extends HttpServlet{
	
	Connection tcon = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PrintWriter out = null;
	RequestDispatcher rd = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		m1(req, resp);
}
	
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		m1(req,resp);
//}
//	
	public void m1(HttpServletRequest req, HttpServletResponse resp){
		resp.setContentType("text/html");
		try{
			HttpSession session = req.getSession(false);
			if(session != null){
			tcon = ConnectionInitiator.createConnection();
			
			out = resp.getWriter();
			
			//taking user data from the session
			String regno = (String)session.getAttribute("regno");
			
			//creating the html form
			//1.including the header
			req.getRequestDispatcher("header").include(req, resp);
			
			//2.creating data for body section
			String query1 = "select * from students_info si, students_guardians_info sgi, students_add_info sai, "
					+ "students_other_info soi "
					+ "where si.regno = ? and sgi.regno = ? and sai.regno = ? "
					+ "and soi.regno = ?";
			
			pstmt = tcon.prepareStatement(query1);
			int testreg = Integer.parseInt(regno);
			pstmt.setInt(1, testreg);
			pstmt.setInt(2, testreg);
			pstmt.setInt(3, testreg);
			pstmt.setInt(4, testreg);
			
			rs = pstmt.executeQuery();
			
			String html =	"<div id='container'>"
							+		"<table id='student_detail'>"
							+			"<tr>"
							+				"<th>Reg No</th>"
							+				"<th>Full Name</th>"
							+				"<th>Guardian Full Name</th>"
							+				"<th>Full Address</th>"
							+				"<th>City</th>"
							+				"<th>Country</th>"
							+				"<th>Admin</th>"
							+			"</tr>";
						
			while(rs.next()){
			String fullAdd = rs.getString("home_no") +", " +rs.getString("street") + ", "+ rs.getString("area");
			String fullName = rs.getString("firstname") +" " +rs.getString("middlename") +" "+ rs.getString("lastname");
			String guardFName = rs.getString("guardian_first_name") + " " + rs.getString("guardian_last_name");
			
			
				html+= 		"<tr>"
					+				"<td>" +testreg + "</td>"
					+				"<td>"+ fullName+"</td>"
					+				"<td>"+ guardFName+"</td>"
					+				"<td>"+ fullAdd +"</td>"
					+				"<td>" + rs.getString("city")+"</td>"
					+				"<td>"+rs.getString("country")+"</td>"
					+				"<td>"+rs.getString("isadmin")+"</td>"
					+		"</tr>";
			}
			
			html += "</table></div>";
			out.print(html);
			//end body data
			
			//3.including footer section
			req.getRequestDispatcher("/footer.html").include(req, resp);
			}//end existing session check
			else{
				out = resp.getWriter();
				out.print("Please Fill the Details!!!");
				resp.sendRedirect("visit");
			}
			
		}//end try block
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