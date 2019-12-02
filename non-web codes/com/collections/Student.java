package com.collections;
public class Student {
String name;
int id;
double cgpa;
public Student(String name, int id, double cgpa)
{
	this.name = name;
	this.id = id;
	this.cgpa = cgpa;
}
public String toString()
{
	return this.id + " " + this.name + " " + this.cgpa;
}
}
