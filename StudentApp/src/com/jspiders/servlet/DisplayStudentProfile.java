package com.jspiders.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DisplayStudentProfile extends HttpServlet{
	Connection tcon = ConnectionInitiator.createConnection();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String mname = req.getParameter("fname");
		String lname = req.getParameter("gender");
		String[] known = req.getParameterValues("known");
		
	}
}
