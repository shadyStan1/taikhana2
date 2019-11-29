package com.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ExtendableBean 
{
    public String name;
    private Map<String, String> properties = new HashMap<>();
 
    public ExtendableBean(String name) {
    	this.name = name;
	}

	@JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

	public void setProperties(String key, String value) {
		properties.put(key, value);
	}
	
}

public class JsonAnyGetterAnnotationDemo {
 public static void main(String[] args) throws JsonProcessingException {
	 ExtendableBean bean = new ExtendableBean("My bean");
	    bean.setProperties("attr1", "val1");
	    bean.setProperties("attr2", "val2");
	    
	    String result = new ObjectMapper().writeValueAsString(bean);
	    
	    System.out.println(result);
 }
}
