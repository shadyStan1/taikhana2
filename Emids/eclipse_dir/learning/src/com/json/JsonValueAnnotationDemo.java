package com.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValueAnnotationDemo {
public static void main(String[] args) throws JsonProcessingException {
	
	String enumAsString = new ObjectMapper()
		      .writeValueAsString(TypeEnumWithValue.TYPE1.getId());
	
	System.out.println(enumAsString);
}
}
