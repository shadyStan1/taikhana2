package com.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierEgToFindRandomName {

	public static void main(String[] args) {
		//to send random names out of an string array
		Supplier<String> supp = () ->
		{
			String[] names = {"aman", "lkr", "bhavya", "farooq", "anushree"};
			
			int index = (int) (Math.random() * 5);
			return names[index];
		};
		
		System.out.println(supp.get());
		
		//to generate an OTP
		Supplier<Integer> suppToGetOTP = () ->
		{
			int[] digits = {0,1,2,3,4,5,6,7,8,9};
			
			int index = (int) (Math.random() * 10);
			return digits[index];
		};
		
		for(int i = 0; i < 4; i++)
		{
			System.out.print(suppToGetOTP.get());
		}

}
}
