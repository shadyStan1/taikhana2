package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePassword extends HttpServlet{
	PrintWriter out = null;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
try{
	out = resp.getWriter();
	HttpSession session = req.getSession(false);
	if(session != null){
		req.getRequestDispatcher("header").include(req, resp);
		
		String regNo = (String)session.getAttribute("regno");
		
		String html =	"<!DOCTYPE html>"
						+	"<html>"
						+	"<head>"
						+		"<title>Change Password</title>"
						+    	"<style>"
						+ 		".label{width : 60px;}"
						+ 		".input1{width : 320px;margin-left: 165px;}"
						+ 		".input2{width : 320px;margin-left: 117px;}"
						+ 		".input3{width : 320px;margin-left: 143px;}"
						+ 		".input4{width : 320px;margin-left: 75px;}"
						+ 		"</style>"
						+	"</head>"	
						+	"<body>"
						+		"<div style='margin-top: 57px;margin-left: 35px;''>"
						+			"<h2 style='color: brown;'>Reset Password!!!!</h2>"
						+			"<form action='http://localhost:8080/StudentApp/resetpassword' method='post'>"
						+			"<fieldset style='width: 58%;'>"
						+				"<legend>"
						+					"Please Enter new password........"
						+				"</legend>"
						+				"<label class=label>User RegNo:</label><input type=text class=input1 name=reg "
						+ 				"value="  +	regNo +"><br>"
						+				"<label class=label>Current Password:</label><input class=input2 type=password name=pswd><br>"
						+				"<label class=label>New Password:</label><input class=input3 type=password name=newpswd><br>"
						+				"<label class=label>Rewrite New Password:</label><input class=input4 type=password name=newpswdagain>"
						+ 				"<br><br>"
				
						+				"<input type=submit name=submit value=Reset>"
				
						+			"</fieldset>"
						+			"</form>"
						+		"</div>"
						+	"</body>"
						+	"</html>";
			
		out.print(html);
	}
	
	else{
		out.print("Please Fill the Details!!!");
		resp.sendRedirect("/login.html");
	}
}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
}
