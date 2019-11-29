package com.debugging;

public class Test {
    public static void main(String args[]) {
        int x=10;
        int y=25;
        int z=x+y;

        System.out.println(m1(x) | m1(y));
    }
    
    public static boolean m1(int x){
    	return x == 10;
    }
}