package com.leetcode.designpatterns.corejava.structural.adapter;
public class SocketClass {

	public Volt getVolt(){
		return new Volt(120);
	}
}