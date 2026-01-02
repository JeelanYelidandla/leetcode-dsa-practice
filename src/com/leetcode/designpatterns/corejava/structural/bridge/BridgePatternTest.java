package com.leetcode.designpatterns.corejava.structural.bridge;

/*
 * Today we will look into Bridge Design Pattern in java. 
 * When we have interface hierarchies in both interfaces as well as implementations, 
 * then bridge design pattern is used to decouple the interfaces from implementation and
 *  hiding the implementation details from the client examples.
 * Decouple an abstraction from its implementation so that the two can vary independently
 * 
 * Bridge design pattern can be used when both abstraction and implementation can have different hierarchies independently
 *  and we want to hide the implementation from the client application.
 * 
 */
public class BridgePatternTest {

	public static void main(String[] args) {
		ShapeAbsClass tri = new Triangle(new RedColor());
		tri.applyColor();
		
		ShapeAbsClass pent = new Pentagon(new GreenColor());
		pent.applyColor();
	}

}