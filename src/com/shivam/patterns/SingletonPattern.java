package com.shivam.patterns;

/*
 * Singleton Pattern
 * 
 * Singleton Pattern ensures that a class has only one instance and provides a global access to it.
 */

public class SingletonPattern {

	public static void main(String[] args) {		

		Singleton singleton = Singleton.getInstance();
		singleton.print();
		
	}

}

class Singleton {
	
	static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
	public void print() {
		System.out.println(this);
	}
	
}