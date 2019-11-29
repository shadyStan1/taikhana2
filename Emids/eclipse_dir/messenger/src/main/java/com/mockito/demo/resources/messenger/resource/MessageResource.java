package com.mockito.demo.resources.messenger.resource;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockito.demo.resources.messenger.DBConnectionInitiator.ConnectionInitiator;
import com.mockito.demo.resources.messenger.Entities.Message;

@Path("/getMessages")
public class MessageResource {
	
	Connection tcon = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessage(@PathParam("id") String id) throws SQLException, JsonProcessingException{
		
		List<Message> messageList = new ArrayList<>();
		tcon = ConnectionInitiator.createConnection();
		
		String query = "select * from message where owner_id = ?";
		pstmt = tcon.prepareStatement(query);
		
		pstmt.setInt(1, Integer.parseInt(id));
		
		rs= pstmt.executeQuery();
		
		while(rs.next())
		{
			Message message = new Message();
			message.setId(rs.getInt(1));
			message.setMessage(rs.getString(2));
			message.setCreatedOn(rs.getDate(3));
			message.setSenderId(rs.getInt(4));
			
			messageList.add(message);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String arrayToJson = objectMapper.writeValueAsString(messageList);
	
		return arrayToJson;
		
	}
	
}
