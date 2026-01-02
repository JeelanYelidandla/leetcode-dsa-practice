package com.leetcode.designpatterns.corejava.structural.bridge;
public class Pentagon extends ShapeAbsClass{

	public Pentagon(ColorInterface c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.print("Pentagon filled with color ");
		color.applyColor();
	} 

}