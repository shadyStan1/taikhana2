package com.revision;

public class PermutationString {

	public static void main(String[] args) {
		String str = "abcd";
		permutation(str);
	}
	public static void permutation(String str) { 
		String s= str.substring(4,4);
		System.out.println(s);
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
