package com.conceptoftheday;
import java.util.*;
public class TrignometricValues {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the angle value");
		double d = sc.nextDouble();
		findTrignVle(d);
		sc.close();
	}
	
	public static void findTrignVle(double d)
	{
		double angle = Math.toRadians(d);
		double sin_of_num = Math.sin(angle);System.out.println(sin_of_num);
		double cos_of_num = Math.cos(angle);
		double tan_of_num = Math.tan(angle);System.out.println(tan_of_num);
		
	}
}
