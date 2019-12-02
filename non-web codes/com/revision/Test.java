package com.revision;

public class Test extends ArithmeticException{
	Test(String string){
	super(string);
}
	public static void main(String[] args) {
		
		throw new Test("/ by zero"); 
	}
}
