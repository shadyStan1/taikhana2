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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res){
		try{

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}