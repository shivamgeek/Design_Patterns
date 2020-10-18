package com.shivam.SOLID;

/*
 * Single Responsibility Principle
 * 
 * A class should have a single reason to change.
 * Each class and module should focus on a single responsibility at a time.
 * With SRP, classes become shorter and cleaner.
 * 
 */

public class SingleResponsibilityPrinciple {

	public static void main(String[] args) {
		

	}

}

/*
 * Before SRP
 */

interface IUserLogin {
	boolean loginUser(String email, String password);
	boolean registerUser(String name, String email, String password);
	void logErrors(String error);
	void sendEmail(String content);
}


/*
 * After SRP
 */

interface IUser {
	boolean loginUser(String email, String password);
	boolean registerUser(String name, String email, String password);
}

interface Logger {
	void logErrors(String error);
}

interface IEmail {
	void sendEmail(String content);
}