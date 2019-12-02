package com.revision;
public class IntegraMicro {
public static void main(String[] args) {
	String []s = {"Hari", "James", "Rahul", "Hari"};
	String []s1 = {"Mahesh", "Marshal", "James", "Rahul"};
	
	String[] newArr = mergerArr(s,s1);
	for(String x: newArr){
		System.out.print(x + ",");
	}
}

public static String[] removeRepeatition(String[] s){
	
	int size = s.length;
	for (int i = 0; i < size-1; i++) {
		for (int j = i+1; j < size; j++) {
		
			if(s[i].equals(s[j])){
				int k = j;
				
				while( k < s.length-1){
					s[k] = s[k+1];
					k++;
				}
				j--; size--;
			}
		}
	}
	
	String[]new_arr = new String[size];
	for (int i = 0; i < size; i++) {
		new_arr[i] = s[i];
	}
	
	return new_arr;
}


public static String[] mergerArr(String[] s, String []s1){
	String[] mergedArr = new String[s.length + s1.length];
	for(int i = 0 ; i<mergedArr.length; i++){
		if(i < s.length){
			mergedArr[i] = s[i];
		}
		else{
			mergedArr[i] = s1[i - s.length];
		}
	}
	mergedArr = removeRepeatition(mergedArr);
	return mergedArr;
}
}
