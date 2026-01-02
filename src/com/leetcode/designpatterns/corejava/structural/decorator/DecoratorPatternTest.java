package com.leetcode.designpatterns.corejava.structural.decorator;

/*
 * Decorator design pattern is used to modify the functionality of an object at runtime.
 *  At the same time other instances of the same class will not be affected by this, so individual 
 *  object gets the modified behavior. Decorator design pattern is one of the structural design pattern 
 *  (such as Adapter Pattern, Bridge Pattern, 
 * Composite Pattern) and uses abstract classes or interface with composition to implement.
 */
public class DecoratorPatternTest {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");
		
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}

}