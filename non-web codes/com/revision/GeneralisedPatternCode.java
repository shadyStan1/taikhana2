package com.revision;
/*
 * A golden code to make things simple
 */
public class GeneralisedPatternCode {
	protected static final String STAR = "* ";
	protected static final String SPACE = "  ";
	private GeneralisedPatternCode(){}
public static void main(String[] args) {
	int[][] pattern = {{0, 0, 0, 1, 0, 0, 0 },						
					   {0, 0, 1, 1, 1, 0, 0 },
					   {0, 1, 1, 1, 1, 1, 0 },
				       {1, 1, 1, 1, 1, 1, 1 },
					   {0, 1, 1, 1, 1, 1, 0 },
					   {0, 0, 1, 1, 1, 0, 0 },
					   {0, 0, 0, 1, 0, 0, 0 },
			
					  }; 
	fetchRow(pattern);
}

public static void fetchRow(int[][] pattern){
	for(int[] row : pattern){
		fetchValue(row);
	}
}

public static void fetchValue(int[] row){
//	for(int x : row){
//		System.out.println(x);
//	}
	for(int x : row){
		
		String s = ((x == 1) ? STAR : SPACE);
		System.out.print(s);
	}
	System.out.println();
}
}
