package com.shivam.patterns;


/*
 * Facade Pattern
 * 
 * Facade pattern provides a unified interface to a set of interfaces in a system.
 * Facade defines a higher level interface that makes the subsystem easier to use.
 * 
 * If we follow the SRP, the we'll end up with many classes as each class has a single responsibility, so it's natural to have 
 * complex wiring in between different classes and each other. It's a natural consequence of having highly decoupled systems.
 * Facade acts as a front face for all the underlying complex wiring between different objects and relationships with each other.
 * It gives a simplistic view to the user.
 * 
 */
public class FacadePattern {

	public static void main(String[] args) {
		/*
		 * Instead of interacting with different objects and calling methods, create a extra facade layer
		 * which acts as a front face object, and use it to call objects methods
		 * 
			Circle circle = new Circle();
			Rectangle rect = new Rectangle();
			Square sq = new Square();
		
			circle.draw();
			rect.draw();
			sq.draw();
		*/
		
		
	      FacadeShapeMaker shapeMaker = new FacadeShapeMaker();

	      shapeMaker.drawCircle();
	      shapeMaker.drawRectangle();
	      shapeMaker.drawSquare();

	}

}

interface Shape {
	   void draw();
}

class Rectangle implements Shape {
	   @Override
	   public void draw() {
	      System.out.println("Rectangle::draw()");
   }
}

class Square implements Shape {
   @Override
   public void draw() {
      System.out.println("Square::draw()");
   }
}

class Circle implements Shape {
   @Override
   public void draw() {
      System.out.println("Circle::draw()");
   }
}


class FacadeShapeMaker {
	
	   private Shape circle;
	   private Shape rectangle;
	   private Shape square;
	
	   public FacadeShapeMaker() {
	      circle = new Circle();
	      rectangle = new Rectangle();
	      square = new Square();
	   }
	
	   public void drawCircle(){
	      circle.draw();
	   }
	   public void drawRectangle(){
	      rectangle.draw();
	   }
	   public void drawSquare(){
	      square.draw();
	   }
	}