package com.json;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class RawBean{
	public String name;
	
	@JsonRawValue
	public String json;
	
	public RawBean(String name, String json) {
		this.name = name;
		this.json = json;
	}
}

public class JsonRawValueDemo {
	public static void main(String[] args) throws JsonProcessingException {
		RawBean raw = new RawBean("aman", "{'attr' : false}");
		
		System.out.println(new ObjectMapper().writeValueAsString(raw));
	}
}
