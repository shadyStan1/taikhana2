package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class CreateProfile extends HttpServlet{
	Connection tcon = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmt4 = null;
	PreparedStatement pstmt5 = null;
	PreparedStatement pstmt6 = null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		/* 
		 * here we collect all the form data
		 * */
		String rno = req.getParameter("regno");
		int regno = Integer.parseInt(rno);
		String password = req.getParameter("pswrd");
		String isadmin = req.getParameter("isadmin");
		
		String course[] = req.getParameterValues("course");
		
		String guarFName = req.getParameter("guarFName");
		String guarLName = req.getParameter("guarLName");
		
		String stuFName = req.getParameter("stuFName");
		String stuMName = req.getParameter("stuMName");
		String stuLName = req.getParameter("stuLName");
		
		String homeno = req.getParameter("homeno");
		String street = req.getParameter("street");
		String area = req.getParameter("area");
		String city = req.getParameter("city");
		String country = req.getParameter("country");
		String pincode = req.getParameter("pincode");
		
		String per_homeno = req.getParameter("per_homeno");
		String per_street = req.getParameter("per_street");
		String per_area = req.getParameter("per_area");
		String per_city = req.getParameter("per_city");
		String per_country = req.getParameter("per_country");
		String per_pincode = req.getParameter("per_pincode");
		
		
		try{
			tcon = ConnectionInitiator.createConnection();
			
			String sql1= "insert into students_info "
					+ "values(?, ?, ?, ?)";
			
			String sql2 = "insert into students_guardians_info "
					+ "values(?,?,?)";
					
		 	String sql3 = "insert into students_other_info "
		 			+ "values(?,?,?)";
		 	
		 	String sql4 = "insert into students_add_info "
		 			+ "values(?,?,?,?,?,?,?,?)";
		 	
		 	String sql5 = "insert into students_add_info "
		 			+ "values(?,?,?,?,?,?,?,?)";
		 	
		 	String sql6 = "insert into mock_rating(regno,courseId) "
		 			+ "values(?,?)";
		 	
		 	pstmt1 = tcon.prepareStatement(sql1);
		 	pstmt2 = tcon.prepareStatement(sql2);
		 	pstmt3 = tcon.prepareStatement(sql3);
		 	pstmt4 = tcon.prepareStatement(sql4);
		 	pstmt5 = tcon.prepareStatement(sql5);
		 	pstmt6 = tcon.prepareStatement(sql6);
		 	
		 	pstmt1.setInt(1, regno);
		 	pstmt1.setString(2, stuFName);
		 	pstmt1.setString(3, stuMName);
		 	pstmt1.setString(4, stuLName);
		 	
		 	pstmt2.setInt(1, regno);
		 	pstmt2.setString(2, guarFName);
		 	pstmt2.setString(3, guarLName);
		 	
		 	pstmt3.setInt(1, regno);
		 	pstmt3.setInt(2, Integer.parseInt(isadmin));
		 	pstmt3.setString(3, password);
		 	
		 	
		 	pstmt4.setInt(1, regno);
		 	pstmt4.setString(2, homeno);
		 	pstmt4.setString(3, street);
		 	pstmt4.setString(4, area);
		 	pstmt4.setString(5, city);
		 	pstmt4.setString(6, country);
		 	pstmt4.setString(7, pincode);
		 	pstmt4.setString(8, "C");
		 	
		 	pstmt5.setInt(1, regno);
		 	pstmt5.setString(2, per_homeno);
		 	pstmt5.setString(3, per_street);
		 	pstmt5.setString(4, per_area);
		 	pstmt5.setString(5, per_city);
		 	pstmt5.setString(6, per_country);
		 	pstmt5.setString(7, per_pincode);
		 	pstmt5.setString(8, "P");
		 	
		 	int x1 = pstmt1.executeUpdate();
		 	int x2 = pstmt2.executeUpdate();
		 	int x3 = pstmt3.executeUpdate();
		 	int x4 = pstmt4.executeUpdate();
		 	int x5 = pstmt5.executeUpdate();
		 	
		 	
		 	for (String cid : course) {
				pstmt6.setInt(1, regno);
				pstmt6.setInt(2, Integer.parseInt(cid));
				pstmt6.executeUpdate();
			}
		 	
		 	if(x1 >= 0 && x2 >= 0 && x3 >= 0 && x4 >= 4 && x5 >= 0){
		 	out.print("Sab dal gaya");
		 	}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
				try {
					if(tcon!=null){
					tcon.close();
					}
					if(pstmt1!=null){
						pstmt1.close();
						}
					if(pstmt2!=null){
						pstmt2.close();
						}
					if(pstmt3!=null){
						pstmt3.close();
						}
					if(pstmt4!=null){
						pstmt4.close();
						}
					if(pstmt5!=null){
						pstmt5.close();
					}
				} 
				catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
		}
		
	}

