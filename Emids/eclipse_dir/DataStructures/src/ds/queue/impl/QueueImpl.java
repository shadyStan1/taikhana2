package ds.queue.impl;

import java.util.Scanner;

public class QueueImpl {
	public static int[] queArr;
	static int front = -1, rear = -1;
	static int sizeOfArr;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of array");
		sizeOfArr = scan.nextInt();
		queArr = new int[sizeOfArr];
		enqueue();
		enqueue();
		enqueue();
		
		dequeue();
		enqueue();
		printQueue();
		dequeue();
		printQueue();
	}

	@SuppressWarnings("resource")
	private static void enqueue() {	
		System.out.println("Enter the element to enqueue");
		Scanner scan = new Scanner(System.in);
		int element = scan.nextInt();
		if (isFull(sizeOfArr))
			System.out.println("Queue is full");

		else if (isEmpty()) {
			front = 0;
			rear = 0;
		}

		else {
			rear = (rear + 1) % sizeOfArr;
		}
		queArr[rear] = element;
	}
	
	private static void dequeue()
	{
		if(isEmpty())
			System.out.println("No elements in queue");
		
		else if(front == 0 && rear == 0)
		{
			front = -1; rear = -1;
		}
		
		else
		{
			front = (front + 1) % sizeOfArr;
		}
	}
	
	private static void printQueue()
	{
		System.out.print("Elements are as follows : ");
		for (int i = front; i < sizeOfArr; i++) {
			System.out.print(queArr[i] + " ");
		}
		System.out.println();
	}

	private static boolean isFull(int sizeOfArr) {
		if ((rear + 1) % sizeOfArr == front)
			return true;
		return false;
	}

	private static boolean isEmpty() {
		if (front == -1 && rear == -1)
			return true;
		return false;
	}
}
