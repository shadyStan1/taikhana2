package com.mockito.demo.resources.messenger.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MessagesFromProfile extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Integer userId = Integer.parseInt(req.getParameter("id"));
		URL url = new URL("http://localhost:9999/messenger/webapi/getMessages/get/?id="+userId);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		 
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("HTTP GET Request Failed with Error code : "
                          + conn.getResponseCode());
        }
        
        //Read the content from the defined connection
        //Using IO Stream with Buffer raise highly the efficiency of IO
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
        String output = null;  
        StringBuffer strBuf = new StringBuffer();
        while ((output = reader.readLine()) != null)  
            strBuf.append(output);  
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print(strBuf);
	}

}
