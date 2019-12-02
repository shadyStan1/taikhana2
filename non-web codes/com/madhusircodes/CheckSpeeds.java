package com.madhusircodes;
public class CheckSpeeds {
	int num; String name; double speeds;
	public CheckSpeeds(String name, double speeds) {
		this.name = name;
		this.speeds = speeds;
	}
	@Override
	public boolean equals(Object ob)
	{
		CheckSpeeds sd2 = (CheckSpeeds) ob; //downcasting
		if(this.speeds == sd2.speeds)
			return true;
		else
		{
			System.out.println("the speed of obj 1 = "+this.speeds + " different from......" 
					+"the speed of obj 2= "
					+ sd2.speeds);
			return false ;
		}
	}
	public static void main(String[] args) {
		CheckSpeeds cs = new CheckSpeeds("ferari", 120.5);
		CheckSpeeds cs1 = new CheckSpeeds("audi", 122.5);
		boolean b = cs.equals(cs1);
		System.out.println(b);
	}
}
