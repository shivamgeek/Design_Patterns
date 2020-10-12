package com.shivam.patterns;


/*
 * Template Method Pattern
 * 
 * Template pattern defines the skeleton of an algorithm in an operation deferring some steps to sub-classes.
 * It lets subclasses redefine certain steps of an algorithm without changing the algorithm structure.
 * 
 * Some parts of code are fixed and some change, so we need to architect a way to use fixed parts of code in way such that they're 
 * not repeated.
 * We use this pattern when we're sure that the template of our method remains the same throughout, also we can mark it as final.
 * This is used very commonly by various frameworks.
 * 
 * 
 */
public class TemplateMethodPattern {

	public static void main(String[] args) {
		
		Game football = new Football();
		football.playGame();

	}

}


abstract class Game {
	abstract void selectGround();
	abstract void doPayment();
	abstract void cleanGround();
	
	final public void playGame() { //Template method, make it as final so overriding is not possible by sub-classes
		System.out.println("Reserve the ground !!!");
		selectGround();
		
		System.out.println("Do payment !!!");
		doPayment();
		
		
		System.out.println("Playing the game ...");
		
		cleanGround();
	}
}


class Football extends Game {

	@Override
	void selectGround() {
		System.out.println("Selected a football ground");
	}

	@Override
	void doPayment() {
		System.out.println("Payment done via cash");
	}

	@Override
	void cleanGround() {
		System.out.println("cleaning the football ground");
	}
	
}

class Hockey extends Game {

	@Override
	void selectGround() {
		System.out.println("Selected a hockey ground");
	}

	@Override
	void doPayment() {
		System.out.println("Payment done via card");
	}

	@Override
	void cleanGround() {
		System.out.println("cleaning the hockey ground");
	}
	
}
