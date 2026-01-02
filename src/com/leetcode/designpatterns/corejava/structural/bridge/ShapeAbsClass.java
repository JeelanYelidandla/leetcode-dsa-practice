package com.leetcode.designpatterns.corejava.structural.bridge;
public abstract class ShapeAbsClass {
	//Composition - implementor
	protected ColorInterface color;
	
	//constructor with implementor as input argument
	public ShapeAbsClass(ColorInterface c){
		this.color=c;
	}
	
	abstract public void applyColor();
}