package com.leetcode.designpatterns.corejava.structural.decorator;

public class BasicCar implements Car {

	@Override
	public void assemble() {
		System.out.print("Basic Car.");
	}

}
