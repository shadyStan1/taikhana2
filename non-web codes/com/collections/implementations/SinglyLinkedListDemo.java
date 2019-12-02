package com.collections.implementations;
public class SinglyLinkedListDemo {
	public static void main(String[] args) {
	LinkedList ll = new LinkedList();
	ll.insertAtStart(1);
	ll.insertAtStart(2);
	ll.insertAtStart(3);
	ll.insertAtStart(4);
	ll.insertAtStart(5);
	ll.insertAtEnd(2);
	ll.insertAtEnd(3);
	ll.insertAtEnd(4);
	ll.insertAtEnd(5);
	ll.insertAtPos(10, 5);
	ll.display();
	ll.deleteAtPos(5);
	ll.display();
} 
}