package com.threads;

import java.sql.SQLException;

public class YuhiEkExample{
	  public static void throwit() throws Exception 	
	  	{
	        System.out.print("throwit ");
	        throw new Exception();
	    }
	    public static void main(String [] args) 
	    {
	        try 
	        {
	            System.out.print("hello ");
	            throwit();
	        }
	        catch (Exception re ) 
	        {
	            System.out.print("caught ");
	        }
	        finally 
	        {
	            System.out.print("finally ");
	        }
	        System.out.println("after ");
	    }
	    
	    
	    
//	static Exception e;
//public static void main(String[] args) {
//	try 
//    {
//        badMethod();  
//        System.out.print("A"); 
//    }  
//    catch (Exception ex) 
//    {
//        System.out.print("B");  
//    } 
//    finally 
//    {
//    System.out.println("C"); 
//    } 
//    System.out.print("D"); 
//}  
//public static void badMethod() 
//{
//	throw new SQLException();
//	//throw e;
//	//throw new RuntimeException();
//    //throw new ArithmeticException("/ by 0");
//}
}
