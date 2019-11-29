package com.java8features;


/*
 * 
 * instance method reference for thread class constructor accepting
 * Runnable object
 */
public class MethodReference3 {
	
	public void runjaisa(){
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getId() + ", "+ i);
		}
	}
	public static void main(String[] args) {
		
		MethodReference3 mr = new MethodReference3();
		Runnable r = mr::runjaisa;
		Thread t = new Thread(r);
		t.start();
	}
}
