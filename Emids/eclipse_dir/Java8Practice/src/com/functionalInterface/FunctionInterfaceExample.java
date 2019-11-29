package com.functionalInterface;

import java.util.Scanner;
import java.util.function.Function;

public class FunctionInterfaceExample {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sentence");
		String sentence = sc.nextLine();
		System.out.println();
		int originalLength = sentence.length();
		System.out.println(sentence + originalLength);
		Function<String, String> functionToRemoveSpaces = s -> s.replaceAll(" ", "");

		String trimmedString = functionToRemoveSpaces.apply(sentence);

		int trimmedLength = trimmedString.length();
		System.out.println(trimmedString + trimmedLength);
		int noOfSpaces = originalLength - trimmedLength;
		System.out.println("the no of spaces in the entered sentence is : " + noOfSpaces);
		sc.close();
	}
}
