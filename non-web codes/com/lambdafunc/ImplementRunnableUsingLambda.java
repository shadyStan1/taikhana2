package com.lambdafunc;
public class ImplementRunnableUsingLambda {
public static void main(String[] args) {
	
	for (int i = 0; i < 5; i++) {
		System.out.println(Thread.currentThread().getName() + " : " +i);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Runnable r1 = ()->
					{
						for (int i = 0; i < 5; i++) {
						
							System.out.println(Thread.currentThread().getName()+  ": "  + i);
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					};
	Runnable r2 = ()->
	{
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+  ": " + i);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	Thread t1 = new Thread(r1);
	Thread t2 = new Thread(r2);
	t1.start();
	t2.start();
}
}
