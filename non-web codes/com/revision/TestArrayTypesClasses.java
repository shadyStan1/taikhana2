package com.revision;

import java.util.Arrays;

public class TestArrayTypesClasses {
public static void main(String[] args) {
TestArrayTypesClasses[] ar = new TestArrayTypesClasses[2];
ar[0] = new TestArrayTypesClasses();
System.out.println(ar[0]);
int[] ar1 = new int[5];
Arrays.fill(ar1, 231);
System.out.println(ar1[2]);
}
}
