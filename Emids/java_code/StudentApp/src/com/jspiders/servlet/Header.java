package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Header extends HttpServlet{
	Connection tcon = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PrintWriter out = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		try{
		out = resp.getWriter();	
		tcon = ConnectionInitiator.createConnection();
		//getting session data 
		HttpSession session = req.getSession(false);
		
			String regNo = (String) session.getAttribute("regno");
			int regNum = Integer.parseInt(regNo);
			
			//building query to fetch data
			String query = "select * from students_info where regno = ?";
			
			pstmt = tcon.prepareStatement(query);
			pstmt.setInt(1, regNum);
			rs = pstmt.executeQuery();
			
			//current date
			Date date = new Date();
			
			String html = "<html><head><title>Student DashBoard</title></head>"
						+ "<body><div id = 'header' style='width : 80%; margin-left: 160px;'>";
			if(rs.first()){
							 html += " <span style='color : brown;'>Welcome " + rs.getString("firstname")
							  + " | </span><span style='color : blue;'>First Login 10 April, 2018 </span>"
							  + " | <span style='color : red;'>Logged At " + date.toString() + "</span> "
							  + " | <a href=./changepassword?user=" + regNo +"><span>Change Password</span></a>"
							  + " | <a href='./logout'><span>Logout</span></a>";
			}
			html += "</div>";
			out.print(html);
			
			req.getRequestDispatcher("/header.html").include(req, resp);
			
		
		}catch(Exception e){
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
