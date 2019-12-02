package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFront extends HttpServlet{
	PrintWriter out = null;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
		try{
			
			String errMess = req.getParameter("message");
			out = resp.getWriter();
			HttpSession session = req.getSession(false);
		if(session == null){
			
			if(errMess != null){
				
				/*
				 * Auto-populating of the register no field using cookie
				 */
				String regValueString = "";
				Cookie[] receivedCookie = req.getCookies();
				if(receivedCookie != null){
					
				for(Cookie cook : receivedCookie){
					if(cook.getName().equals("regno")){
						String value = cook.getValue();
						regValueString  = value;
					}
					else{
						regValueString  = "";
					}
				}
			}
			else{
				
				regValueString  = "";
			}
				
		String html = "<!DOCTYPE html>"
			      +"<html>"
			      + "<head>"
			      +"<title>Welcome To StudentApp</title>"
			      
			      + "<style>"
			      + ".error{"
			      + "color : red;"
			      + "margin-left : 163px;"	
			      + "}"
			      + "</style>" 
			      +"</head>"
			      +"<body>"
			      +"<div><span style='color : red;'>"+ errMess+"</span></div>"
			      +"<div style='margin-top: 57px;margin-left: 35px;'>"
			      +"<h3 style='color: brown;'>Login!!!!</h3>"
			      +"<form id=login_form action = http://localhost:8080/StudentApp/login method=post> "
			      +"<fieldset style=width:45%;>"
			      +"<legend>"
			      +"Please Enter your username and password........"
			      +"</legend>"
			      + "<label>Registration No:</label><input id=regno type='text' style=margin-left:30px size=35 name='regno' value="
			      + regValueString
			      + "><br>"
			      +"<label>Password:</label><input type='password' id=pswd style=margin-left:80px size=35 name='pswd'><br>"
			      +"<label>Remember Me?</label><input type='checkbox' style=margin-left:38px name='remember' value='remember'><br><br>"
				  +"<input type='submit' name='submit'>&nbsp&nbsp"
				  + "<a href='http://localhost:8080/StudentApp/studentcompleteprofile.html'>"
				  +"<input type='button' name='create_new' value='Create An Account'></a>"
				  +"</fieldset>"
				  +"</form>"
				  +"</div>"
				  + "<script src=js/jquery-3.1.1.js></script>"
				  + "<script src=js/login-js.js></script>"
				  + "<script src=js/jquery.validate.js></script>"
				  +"</body>"
				  +"</html>";
		
		out.print(html);
			}
			else{
				
				String regValueString = "";
				Cookie[] receivedCookie = req.getCookies();
				if(receivedCookie != null){
					
				for(Cookie cook : receivedCookie){
					if(cook.getName().equals("regno")){
						String value = cook.getValue();
						regValueString  = value;
					}
					else{
						regValueString  = "";
					}
				}
			}	
				else{
					
					regValueString  = "";
				}
				String html = "<!DOCTYPE html>"
					      +"<html>"
					      + "<head>"
					      +"<title>Welcome To StudentApp</title>"
					      + "<style>"
					      + ".error{"
					      + "color : red;"
					      + "margin-left : 163px;"					      
					      + "}"
					      + "</style>" 
					      +"</head>"
					      +"<body>"
					      +"<div style='margin-top: 57px;margin-left: 35px;'>"
					      +"<h3 style='color: brown;'>Login!!!!</h3>"
					      +"<form id=login_form action = http://localhost:8080/StudentApp/login method=post> "
					      +"<fieldset style=width:45%;>"
					      +"<legend>"
					      +"Please Enter your username and password........"
					      +"</legend>"
					      + "<label>Registration No:</label><input id=regno type='text' size=35 style=margin-left:30px name='regno' value="
					      + regValueString
					      + "><br>"
					      +"<label>Password:</label><input id=pswd type='password' size=35 style=margin-left:80px name='pswd'><br>"
					      +"<label>Remember Me?</label><input type='checkbox' style=margin-left:38px name='remember' value='remember'><br><br>"
						  +"<input type='submit' name='submit'>&nbsp&nbsp"
						  + "<a href='http://localhost:8080/StudentApp/studentcompleteprofile.html'>"
						  +"<input type='button' name='create_new' value='Create An Account'></a>"
						  +"</fieldset>"
						  +"</form>"
						  +"</div>"
						  + "<script src=js/jquery-3.1.1.js></script>"
						  + "<script src=js/login-js.js></script>"
						  + "<script src=js/jquery.validate.js></script>"
						  +"</body>"
						  +"</html>";
				
				out.print(html);
			}
		}//end session null check
			else{
				resp.sendRedirect("dashboard");
			}
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		
	}
	}
}
