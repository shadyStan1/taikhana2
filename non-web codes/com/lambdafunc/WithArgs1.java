package com.lambdafunc;
@FunctionalInterface
interface ABC
{
	int add(int a, int b);
}
public class WithArgs1 {
	public void methodOfClass(ABC ab, int a, int b)
	{
		int sum = ab.add(a, b);
		System.out.println(sum);
	}
public static void main(String[] args) {
	WithArgs1 a1 = new WithArgs1();
	
	ABC ab = (int a, int b)->
			{
				int c = a + b;
				return c;
			};
	ABC a2 = (int a, int b )->
	{	
		int c = a + b;
		return c;
	};
	a1.methodOfClass(ab, 10, 20);
	a1.methodOfClass(a2, 434, 434);
}
}
