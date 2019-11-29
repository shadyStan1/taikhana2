package com.threads;
class ShowGesture{
	public synchronized void wish(String name){
		for (int i = 0; i < 10; i++) {
			
			System.out.print("Good Morning : ");
			try{
			Thread.sleep(2000);
			}
			catch(InterruptedException ie)
			{
				System.out.println(ie);
			}
			System.out.println(name);
		}
	}
}
class MyThread extends Thread{
	ShowGesture sg = null;
	String name = "";
	MyThread(ShowGesture sg, String name)
	{
		this.sg = sg;
		this.name = name;
	}
	
	public void run(){
		sg.wish(name);
	}
}
public class SynchMethodDemo {

	public static void main(String[] args) {
	ShowGesture sg = new ShowGesture();
	MyThread t = new MyThread(sg, "aman");
	MyThread t1 = new MyThread(sg, "thande raho bhai");
	t.start();
	t1.start();
	}
	
}
