package meri.padhai.basic;

public class ProducerConsumerMultiThreadingProblem {

	public static void main(String[] args) 
	{
		final PC pc = new PC();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				
				try{
					pc.produce();
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				try{
					pc.consume();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				
			}
			
		});
		t1.start();
		t2.start();
	}
	
	public static class PC
	{
		public void produce() throws InterruptedException
		{
			
			synchronized (this)
			{
				
			System.out.println("running produce method");
			
			wait();
			
			System.out.println("resume");
			//
		}
	}
		
		public void consume() throws InterruptedException
		{
			Thread.sleep(2000);
			
			synchronized (this) 
			{
				System.out.println("after wait is called");
				
				System.out.println("calling notify");
				notify();
				
				Thread.sleep(2000);
				
			}
		}
	}
}
