package com.revision;

public class TestArrayInitialisation {
public static void main(String[] args) {
	String[] argh = {"X", "Y", "H"};
	argh = args;

	for(String s : argh){
		System.out.println(s);
	}
}
}
