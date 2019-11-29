package meri.padhai.basic;

import java.util.concurrent.TimeUnit;

public class ExecutionSpeed {
	public static void main(String[] args) throws Exception{
		
		
		System.out.println("testing the time of below for loop");
		
		long t = 0;
		long startTime = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			t++;
			Thread.sleep(1000);
		}
		
		long endTime = System.nanoTime();
		
		System.out.println(TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
		
		
	}
}
