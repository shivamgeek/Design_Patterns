package com.shivam.SOLID;

/*
 * Liskov Substitution Principle
 * 
 * If S is a subtype of T, then objects of type T may be replaced with objects of type S.
 * Derived types must be completely substitutable for their base types.
 * This is a extension of OCP.
 * New derived classes should not add more conditions in the over-ridden methods than the base methods or change it's functionality.
 * It can change how it does certain function, but not what of the function.
 */

public class LiskovSubstitutionPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * Before LSP
*/

abstract class Coffee {
	int price;
	String name;
	int sugarCubes;
	boolean isSteamed;
	boolean hasFoam;
	int coffeeBeans;
	
	boolean hasSteam() {
		return isSteamed;
	}
	
	boolean withFoam() {
		return hasFoam;
	}
	
	boolean isStrong() {
		if(coffeeBeans > 5) {
			return true;
		}else {
			return false;
		}
	}
}

class MochaCoffee extends Coffee {
	public MochaCoffee(){
		sugarCubes = 4;
		coffeeBeans = 4;
	}
}

class AmericanoCoffee extends Coffee {
	public AmericanoCoffee(){
		sugarCubes = 2;
		coffeeBeans = 5;
	}
}

class Tea extends Coffee {
	public Tea() {
		coffeeBeans = 3; // This is a violation. Tea is not a coffee. Tea is not substitutable for type Coffee
	}
}


/*
 * Using LSP 
 */

abstract class Beverage {
	int price;
	String name;
	int sugarCubes;
}

class CoffeeBeverage extends Beverage {
	boolean isSteamed;
	boolean hasFoam;
	int coffeeBeans;
	
	boolean hasSteam() {
		return isSteamed;
	}
	
	boolean withFoam() {
		return hasFoam;
	}
	
	boolean isStrong() {
		if(coffeeBeans > 5) {
			return true;
		}else {
			return false;
		}
	}
}

class MochaCoffeeBeverage extends CoffeeBeverage {
	public MochaCoffeeBeverage(){
		sugarCubes = 4;
		coffeeBeans = 4;
	}
}

class AmericanoCoffeeBeverage extends CoffeeBeverage {
	public AmericanoCoffeeBeverage(){
		sugarCubes = 2;
		coffeeBeans = 5;
	}
}

class TeaBeverage extends Beverage {
	public TeaBeverage() {
		sugarCubes = 3; // Now tea is a Bevarage
	}
}