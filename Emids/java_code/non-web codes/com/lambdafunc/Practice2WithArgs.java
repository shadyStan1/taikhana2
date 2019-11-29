package com.lambdafunc;
@FunctionalInterface
interface FunctIntr2
{
	void methd1();
}
public class Practice2WithArgs 
{
	public void amthd1(FunctIntr2 fr)
	{
		System.out.println("check out");
		fr.methd1();
	}
	public static void main(String[] args)
	{
		Practice2WithArgs a1 = new Practice2WithArgs();
		FunctIntr2 fr = ()->
						{
							System.out.println("pass using object of the class");
						};
		a1.amthd1(fr);
	}
	
}
