package com.collections;

import java.util.Comparator;

public class CompleteComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		int x = 0;
		if(o1 instanceof Integer && o2 instanceof Integer)
		{
			Integer i1 = (Integer) o1;
			Integer i2 = (Integer) o2;
			x = i1-i2;	
		}
		
		else if(o1 instanceof String && o2 instanceof String){
			String s1 = (String) o2;
			String s2 = (String) o1;
			x = s2.compareTo(s1);
		}
		return x;
	}


}
