package com.collections.implementations;

public class Node{
	protected Node link;
	protected int data;
	
	public Node(){
		link = null;
		data = 0;
	}
	/*this constructor defines a node with a value and a link to other node */
	public Node(int val, Node n)
	{
		data = val;
		link = n;
	}
	
	/* this method sets a link for a node to some node*/
	public void setLink(Node n)
	{
		link = n;
	}
	
	/* this returns the object to which a current object points*/
	public Node getLink()
	{
		return link;
	}
	/*this () sets data for a node object */
	public void setData(int val)
	{
		data = val;
	}
	
	/*this () returns the data which a node object holds */
	public int getData()
	{
		return data;
	}	
}
