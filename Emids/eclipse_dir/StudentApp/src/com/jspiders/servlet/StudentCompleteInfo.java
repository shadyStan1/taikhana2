package com.jspiders.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;

public class StudentCompleteInfo extends HttpServlet {
	Connection tcon = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		String regno = (String) session.getAttribute("regno");
		int rno = Integer.parseInt(regno);

		try {

			tcon = ConnectionInitiator.createConnection();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();

			String query = "select * from students_info si, students_guardians_info sgi, students_add_info sai, "
					+ "students_other_info soi " + "where si.regno = ? and sgi.regno = ? and sai.regno = ? "
					+ "and soi.regno = ?";

			pstmt = tcon.prepareStatement(query);

			pstmt.setInt(1, rno);
			pstmt.setInt(2, rno);
			pstmt.setInt(3, rno);
			pstmt.setInt(4, rno);

			rs = pstmt.executeQuery();

			String html = "<div id='container'>" + "<table>" + "<tr>" + "<th>Reg No</th>" + "<th>Full Name</th>"
					+ "<th>Guardian Full Name</th>" + "<th>Full Address</th>" + "<th>City</th>" + "<th>Country</th>"
					+ "<th>Admin</th>" + "</tr>";

			while (rs.next()) {
				String fullAdd = rs.getString("home_no") + ", " + rs.getString("street") + ", " + rs.getString("area");
				String fullName = rs.getString("firstname") + " " + rs.getString("middlename") + " "
						+ rs.getString("lastname");
				String guardFName = rs.getString("guardian_first_name") + " " + rs.getString("guardian_last_name");

				html += "<tr>" + "<td>" + rno + "</td>" + "<td>" + fullName + "</td>" + "<td>" + guardFName + "</td>"
						+ "<td>" + fullAdd + "</td>" + "<td>" + rs.getString("city") + "</td>" + "<td>"
						+ rs.getString("country") + "</td>" + "<td>" + rs.getString("isadmin") + "</td>" + "</tr>";
			}

			html += "</table></div>";
			out.print(html);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (tcon != null)
					tcon.close();

				if (pstmt != null)
					pstmt.close();

				if (rs != null)
					rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
