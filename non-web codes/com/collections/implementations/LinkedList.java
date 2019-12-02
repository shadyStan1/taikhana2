package com.collections.implementations;
public class LinkedList{
	
	protected Node start;
	protected Node end;
	public int size;
	
	public boolean isEmpty(){
		return start == null;
	}
	
	public int getSize(){
		return size;
	}
	
	public void insertAtStart(int val){
		Node temp = new Node(val, null);
		size++;
		if(start == null)
		{
			start = temp;
			end = temp;
		}
		else
		{
			temp.setLink(start);
			start = temp;
		}
	}
	
	
	public void insertAtEnd(int val){
	Node temp = new Node(val, null);
	size++;
	if(end == null)
	{
		start = temp;
		end = temp;
	}
	else{
		end.setLink(temp);
		end = temp;
	}	
	}
	
	public void insertAtPos(int val, int pos)
	{
		Node newNode = new Node(val,null);
		Node ptr = start;
		pos = pos - 1;
		
		for (int i = 1; i < size; i++) {
			if(i == pos)
			{
				Node temp = ptr.getLink();
				//temp.setLink(newNode);
				newNode.setLink(temp);
				ptr.setLink(newNode);
			}
			ptr = ptr.getLink();
		}
		size++;
	}
	
	public void deleteAtPos(int pos){
		System.out.println();
		if(pos == 1)
		{
			start = start.getLink();
			size--;
			return;
		}
		
		if(pos == size){
			Node s = start;
			Node t = start;
			
			while(s != end)
			{
				t = s;
				s = s.getLink();
			}
			end = t;
			end.setLink(null);
			size--;
			return;
		}
		
		Node ptr = start;
		pos = pos - 1;
		
		for(int i = 1; i < size ; i++)
		{
			if( i == pos)
			{
				Node temp = ptr.getLink();
				temp = temp.getLink();
				ptr.setLink(temp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}
	
	public void display(){
		System.out.println("Singly Linked list :-");
		if(size == 0){
			System.out.println("empty");
			return;
		}
		if(start.getLink() == null){
			System.out.println(start.getData());
			return;
		}
		Node ptr = start;
		System.out.print(start.getData() + " -> ");
		ptr = start.getLink();
		
		while(ptr.getLink() != null)
		{
			System.out.print(ptr.getData() + " -> ");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData());
	}
}
