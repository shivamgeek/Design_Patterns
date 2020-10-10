package com.shivam.patterns;

import java.util.Random;

/*
 * FACTORY METHOD PATTERN
 * 
 * Factory pattern defines an interface, for creating an object, but lets sub-classes decide what instance to create.
 * If during object creation you need to have some business logic such as some useful parameters while creating object,
 * or more importantly identifying the type of object to be created at runtime.
 * 
 * We create multiple types of factory each of them have their own business logic to create objects at runtime.
 * It creates a single object as opposed to Abstract factory pattern
 *   
 */

public class FactoryMethodPattern {

	public static void main(String[] args) {
		AnimalFactory factory = new RandomAnimalFactory();
		Animal animal = factory.createAnimal();
		animal.eat();
		animal.walk();
		animal.sleep();
	}

}


interface Animal {
	void walk();
	void eat();
	void sleep();
}

interface AnimalFactory {
	Animal createAnimal();
}


class Dog implements Animal {

	@Override
	public void walk() {
		System.out.println(this.getClass().getName()+" is walking");
	}

	@Override
	public void eat() {
		System.out.println(this.getClass().getName()+" is eating");
	}

	@Override
	public void sleep() {
		System.out.println(this.getClass().getName()+" is sleeping");
	}
	
}

class Duck implements Animal {

	@Override
	public void walk() {
		System.out.println(this.getClass().getName()+" is walking");
	}

	@Override
	public void eat() {
		System.out.println(this.getClass().getName()+" is eating");
	}

	@Override
	public void sleep() {
		System.out.println(this.getClass().getName()+" is sleeping");
	}
	
}

class Monkey implements Animal {

	@Override
	public void walk() {
		System.out.println(this.getClass().getName()+" is walking");
	}

	@Override
	public void eat() {
		System.out.println(this.getClass().getName()+" is eating");
	}

	@Override
	public void sleep() {
		System.out.println(this.getClass().getName()+" is sleeping");
	}
	
}

/* this factory generates a animal randomly */
class RandomAnimalFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		int rand = new Random().nextInt(3);
		if(rand == 0) { return new Dog(); }
		else if(rand == 1) { return new Monkey(); }
		else { return new Duck(); }
	}
	
}

/* this factory generates a animal sequentially */
class SequentialAnimalFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		return new Dog();
	}
	
}

