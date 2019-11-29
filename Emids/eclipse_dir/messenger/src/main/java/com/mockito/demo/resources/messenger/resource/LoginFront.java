package com.mockito.demo.resources.messenger.resource;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginFront extends HttpServlet
{
	PrintWriter out = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		
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
			      +"<div><span style='color : red;'> </span></div>"
			      +"<div style='margin-top: 57px;margin-left: 35px;'>"
			      +"<h3 style='color: brown;'>Login!!!!</h3>"
			      +"<form id=login_form action = http://localhost:8080/StudentApp/login method=post> "
			      +"<fieldset style=width:45%;>"
			      +"<legend>"
			      +"Please Enter your username and password........"
			      +"</legend>"
			      + "<label>Registration No:</label><input id=regno type='text' style=margin-left:30px size=35 name='regno' value="
			      
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
 
}
