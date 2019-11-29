package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResetPassword extends HttpServlet{
	Connection tcon = null;
	PreparedStatement pstmt = null;
	PrintWriter out = null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try{
			tcon = ConnectionInitiator.createConnection();
			out = resp.getWriter();
			HttpSession session = req.getSession(false);
			
			if(session != null){
				String regno = req.getParameter("reg");
				int rno = Integer.parseInt(regno);
				String oldPassword = req.getParameter("pswd");
				String newPassword = req.getParameter("newpswd");
				
				String query = "update students_other_info set password = ? where regno = ? and password = ?";
				
				pstmt = tcon.prepareStatement(query);
				
				pstmt.setString(1, newPassword);
				pstmt.setInt(2, rno);
				pstmt.setString(3, oldPassword);
				
				int result = pstmt.executeUpdate();
				
				if(result == 1){
					session.invalidate();
					String mess = "Password Reset Successful";
					resp.sendRedirect("visit?message="+mess);
				}
				else{
					out.print("Please Fill the Correct Details!!!");
					resp.sendRedirect("changepassword?user"+regno);
				}
			}
			else{
				out.print("Please Fill the Details!!!");
				resp.sendRedirect("login");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(tcon!= null)
				tcon.close();
				
				if(pstmt!= null)
					pstmt.close();
								
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
