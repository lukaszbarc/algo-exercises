package com.lbarc.aglo.exercises.crackingcodeinterview.arraysandstrings;

public class BitArray {

	public static void main(String[] args) {
		int array = 0;
		System.out.println("array: " + Integer.toBinaryString(array));

		int mask1 = 1 << 4;
		int mask2 = 1 << 8;
		System.out.println("mask1: " + Integer.toBinaryString(mask1));
		System.out.println("mask2: " + Integer.toBinaryString(mask2));

		array |= mask1;
		array |= mask2;
		System.out.println("array: " + Integer.toBinaryString(array));
	}
}
