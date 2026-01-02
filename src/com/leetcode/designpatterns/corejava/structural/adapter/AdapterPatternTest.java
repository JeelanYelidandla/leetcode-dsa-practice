package com.leetcode.designpatterns.corejava.structural.adapter;
public class AdapterPatternTest {

/*
 * Adapter design pattern is one of the structural design pattern and its used so that two unrelated interfaces can work together.
 *  The object that joins these unrelated interface is called an Adapter.
 * Some of the adapter design pattern example I could easily find in JDK classes are;
 * 
 * One of the great real life example of Adapter design pattern is mobile charger.
 *  Mobile battery needs 3 volts to charge but the normal socket produces either 120V (US) or 240V (India). 
 * So the mobile charger works as an adapter between mobile charging socket and the wall socket.

So first of all we will have two classes � Volt (to measure volts) and Socket (producing constant volts of 120V).

Example of Adapter Pattern in JDK
java.util.Arrays#asList()
java.io.InputStreamReader(InputStream) (returns a Reader)
java.io.OutputStreamWriter(OutputStream) (returns a Writer)
 */
public static void main(String[] args) {
		
		testClassAdapter();
//		testObjectAdapter();
	}

	/*private static void testObjectAdapter() {
		SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
		Volt v3 = getVolt(sockAdapter,3);
		Volt v12 = getVolt(sockAdapter,12);
		Volt v120 = getVolt(sockAdapter,120);
		System.out.println("v3 volts using Object Adapter="+v3.getVolts());
		System.out.println("v12 volts using Object Adapter="+v12.getVolts());
		System.out.println("v120 volts using Object Adapter="+v120.getVolts());
	}*/

	private static void testClassAdapter() {
		SocketAdapterInterface sockAdapter = new SocketClassAdapterImpl();
		Volt v3 = getVolt(sockAdapter,3);
		Volt v12 = getVolt(sockAdapter,12);
		Volt v120 = getVolt(sockAdapter,120);
		System.out.println("v3 volts using Class Adapter="+v3.getVolts());
		System.out.println("v12 volts using Class Adapter="+v12.getVolts());
		System.out.println("v120 volts using Class Adapter="+v120.getVolts());
	}
	
	private static Volt getVolt(SocketAdapterInterface sockAdapter, int i) {
		switch (i){
		case 3: return sockAdapter.get3Volt();
		case 12: return sockAdapter.get12Volt();
		case 120: return sockAdapter.get120Volt();
		default: return sockAdapter.get120Volt();
		}
	}
}