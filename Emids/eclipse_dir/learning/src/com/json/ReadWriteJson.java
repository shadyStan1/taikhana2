package com.json;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadWriteJson {
   public static void main(String args[]) throws JSONException{
	   ReadWriteJson tester = new ReadWriteJson();
	   List<StudentDemo> stu = new ArrayList<>();
      try {
    	  for (int i = 0; i < 3; i++) {
    		  StudentDemo student = new StudentDemo();
    	         student.setAge(i);
    	         student.setName("Mahesh - " + i);
    	         stu.add(student);
    	         
		}
    	  System.out.println(stu);
    	  //tester.writeJSON(stu);
          ObjectMapper mapper = new ObjectMapper();	
          JSONObject obj = new JSONObject();
          obj.put("list", stu);
          
          
   	   JSONArray jArray = obj.getJSONArray("list");
   	   for(int ii=0; ii < jArray.length(); ii++)
   	     System.out.println(jArray.getJSONObject(ii).getString("value"));

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

//   private void writeJSON(List<Student> student) throws JsonGenerationException, JsonMappingException, IOException, JSONException{
//
//      
////      File f = new File("/home/amanv/Documents/eclipse_dir/student.json");
////      
////      mapper.writeValue(f, obj);
//      
//      System.out.println("file created");
//   }
//
//   private StudentDemo readJSON() throws JsonParseException, JsonMappingException, IOException{
////      ObjectMapper mapper = new ObjectMapper();
////      StudentDemo student = mapper.readValue(new File("/home/amanv/Documents/student.json"), StudentDemo.class);
////      return student;
//return null;
//   }
}

class StudentDemo implements Serializable {
   private String name;
   private int age;
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public String toString(){
      return "Student [ name: "+name+", age: "+ age+ " ]";
   }	
}