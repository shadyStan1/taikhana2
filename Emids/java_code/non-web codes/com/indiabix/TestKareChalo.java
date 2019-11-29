package com.indiabix;

public class TestKareChalo {
	   public static void main(String [] args) 
	    {
		   TestKareChalo p = new TestKareChalo();
		  //  Test p = new Test();
	        p.start();
	    }

	    void start() 
	    {
	        boolean b1 = false;
	        boolean b2 = fix(b1);
	        System.out.println(b1);
	        System.out.println(b2);
	        System.out.println(b1 + " " + b2);
	    }

	    boolean fix(boolean b1) 
	    {
	        b1 = true;
	        System.out.println(b1);
	        return b1;
	    }
}
