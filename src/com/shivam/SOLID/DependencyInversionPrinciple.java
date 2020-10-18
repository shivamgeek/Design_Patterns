package com.shivam.SOLID;

/*
 * Dependency Inversion Principle
 * High level modules should not depend on low level modules. Both should depend on abstractions.
 * Abstractions should not depend on details. Details should depend on abstractions.
 * 
 */

public class DependencyInversionPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * A good example for DIP is sorting an array in java.
 * Sorting could had an in built functionality to sort but in that case sorting would be have an dependency with that 
 * algorithm. But what we do is pass an object of comparator which has that algorithm.
 * So in a way we're injecting the dependency or making the high level module not dependent on low level module.
 *
 */