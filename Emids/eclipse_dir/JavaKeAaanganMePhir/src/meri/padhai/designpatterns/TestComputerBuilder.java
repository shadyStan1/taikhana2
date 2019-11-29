package meri.padhai.designpatterns;

import java.util.ArrayList;

public class TestComputerBuilder {

	public static void main(String[] args) {
		
//		Computer pc = new Computer.ComputerBuilder("500 gb", "1 TB hdd")
//				.buildComputer();
//		
//		System.out.println(pc.getHdd());
//		System.out.println(pc.getRam());
//		Object my = new String[]{"one", "two", "three"};
//		{
//			for(String s : (String[])my)
//			{
//				System.out.println(s + ".");
//			}
//		}
//		StringBuffer bf = new StringBuffer("polls tests");
//		bf.insert(6, "Good ");
//		System.out.println(bf);
//		
//		ArrayList<int> iii = new ArrayList<int>;
		
		int r = (int)(Math.floor(Math.random() * 8)) + 2;
		
		System.out.println(r);
	}
}
