package com.shivam.SOLID;

/*
 * Open Closed Principle
 * 
 * Software entities such as classes, modules, functions etc should be open for extension, but closed for modification.
 * Any new functionality should be implemented by adding new classes, modules or functions instead of changing the existing ones.
 * 
 */
public class OpenClosePrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * Before OCP
 */

// Employee class needs to have different types of bonus for permanent and temporary employees, so we need to introduce a new 
// variale as "type" and put checks on it. This modifies the existing code.

class Employee {
	String firstName, lastName;
	float salary;
	
	String empType;
	
	float getBonus() {
		if(empType == "Permanent") {
			return (float) (salary * 0.5);
		}else {
			return (float) (salary * 0.2);
		}
	}
	
	float getSalary() {
		return salary;
	}
}


// Using OCP

abstract class GeneralEmployee {
	String firstName, lastName;
	float salary;
	
	abstract float getBonus();
	
	float getSalary() {
		return salary;
	}
}

class PermanentEmployee extends GeneralEmployee {
	public float getBonus() {
		return (float) (salary * 0.5);
	}
}

class TemporaryEmployee extends GeneralEmployee {
	public float getBonus() {
		return (float) (salary * 0.2);
	}
}