package com.leetcode.designpatterns.corejava.structural.bridge;
public class Triangle extends ShapeAbsClass{

	public Triangle(ColorInterface c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Triangle filled with color ");
		color.applyColor();
	} 

}