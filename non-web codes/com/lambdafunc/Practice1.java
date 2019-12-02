package com.lambdafunc;
@FunctionalInterface //contains only one method
interface FuntionalIntrfce
{
public abstract void mthd1();	
}
public class Practice1    //don't require writing implements FuntionalIntrfce 
{
	public static void main(String[] args) {
	
FuntionalIntrfce fi = 		()->
							{
								System.out.println("abe ho jayga darne ka ni");
								return;
							};
							fi.mthd1();
}
}