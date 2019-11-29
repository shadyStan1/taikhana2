package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
	
	Connection tcon = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PrintWriter out = null;
	RequestDispatcher rd = null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		m1(req,resp);
}
	
	public void m1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String reg = "";
		String pass = "";
		String remember = "";
		try{
		tcon = ConnectionInitiator.createConnection();
		resp.setContentType("text/html");
		out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session == null){
			
			reg = req.getParameter("regno");
			pass = req.getParameter("pswd");
			
			if(req.equals("") || "".equals(pass)){
				
				String err = "Please Fill The Following Details";
				resp.sendRedirect("visit?message="+err);

			}//end empty parameter check block
			
			else{
				
				remember = req.getParameter("remember");
				/*
				 * checking existence of cookie 
				 * if not present then creating one and adding to the response
				 */
				if("".equals(remember) == false){
					Cookie[] receivedCookie = req.getCookies();
					if(receivedCookie != null){
					for(Cookie biscuit : receivedCookie){
						if(!biscuit.getName().equals("regno")){
							Cookie newCookie = new Cookie("regno", reg );
							newCookie.setMaxAge(7*24*60*60);
							resp.addCookie(newCookie);
						}
					}
				}
			}		
				
				String query = "select * from students_other_info where regno = ? and password = ?";
				
				pstmt = tcon.prepareStatement(query);
				
				pstmt.setInt(1, Integer.parseInt(reg));
				pstmt.setString(2, pass);
				
				rs= pstmt.executeQuery();
				
					if(!rs.first()){
						
						String err = "Oopss!No Such User Exists or the credentials are wrong";
						
						resp.sendRedirect("visit?message="+err);
						
						
					}//end unknown user block
					
					else{
						session = req.getSession(true);
						session.setAttribute("regno", reg );
						
						resp.sendRedirect("dashboard");
					}//end known user block
					
			}//end filled parameter check block
			
	}//ends session null check
		
		else{
			session = req.getSession(false);
			reg = req.getParameter("reg");
			session.setAttribute("regno", reg);
			resp.sendRedirect("dashboard");
		}//end session not null block
		
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
