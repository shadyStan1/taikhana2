package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStudentServlet extends HttpServlet{
	
	Connection tcon = ConnectionInitiator.createConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String regnum = req.getParameter("regnum");
		int rno = Integer.parseInt(regnum);
		String sql = "Select * from students_info si, students_guardians_info so "
				+ "where si.regno = ?  & so.regno = ?";
		resp.setContentType("text/html");
		try {
			pstmt = tcon.prepareStatement(sql);
			
			pstmt.setInt(1,rno);
			pstmt.setInt(2, rno);
			//System.out.println(regno);
			rs = pstmt.executeQuery();
			
			StringBuffer html = new StringBuffer("<html><head></head><body>");			
			String htmlBody = "<table><tr><th>Sno<th><th>Regno</th>+"
					+ "<th>Student Full Name</th>"
					+ "<th>Guardian Full Nam</th></tr>";			
			
			int sno = 0;
			
			while(rs.next()){
				String fName = rs.getString("firstname") + " " + rs.getString("middlename") 
							+ " " +  rs.getString("lastname");
				String gName = rs.getString("guardian_first_name") + " "
							   + rs.getString("guardian_last_name");
				htmlBody += "<tr><td>" +sno + "</td>" +
							"<td>"+rno +"</td>"+
							"<td>" + fName + "</td>"+
							"<td>" +gName + "</td></tr>";
							html.append(htmlBody); 
				sno++;
			}
			
			html.append("</table></body></html");
			
			out.print(html);
			
		} catch (SQLException e) {
			out.print(rno);
			e.printStackTrace();
		}
		finally {
			
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
