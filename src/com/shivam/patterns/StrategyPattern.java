package com.shivam.patterns;


/*
 * Strategy Pattern
 * 
 * Strategy pattern defines a family of algorithms, encapsulates each one and makes them interchangeable.
 * It lets the algorithm vary from the client that uses it.
 * 
 * Promotes composition over inheritance, ie better to have HAS-A rather than IS-A relationship.
 */
public class StrategyPattern {

	public static void main(String[] args) {
		
		PayMethod payMethod = new DebitCardPayMethod();
		
		Customer customer = new Customer(payMethod);
		
		customer.payBill();
		
	}

}

interface PayMethod {
	void doPayment();
	void getRecipt();
}

/*
 * Instead of extending Customer class with PayMethod class and implementing it's own algorithm, we use composition 
 * so that the customer HAS-A a payment method.
 * This is useful as if in future some other class also needs payment methods, they can simply have a PayMethod.
 * As per the definition, now algorithm can vary from the class that uses it and are interchangeable.
 * 
 */
class Customer {
	
	private PayMethod payMethod;

	public Customer(PayMethod payMethod) {
		this.payMethod = payMethod;
	}
	
	void payBill() {
		payMethod.doPayment();
		payMethod.getRecipt();
	}
	
}

class CreditCardPayMethod implements PayMethod {

	@Override
	public void doPayment() {
		System.out.println("Payment done via Credit-card");
	}

	@Override
	public void getRecipt() {
		System.out.println("Here's the recipt after paying with credit card");
	}
	
}

class DebitCardPayMethod implements PayMethod {

	@Override
	public void doPayment() {
		System.out.println("Payment done via Debit-card");
	}

	@Override
	public void getRecipt() {
		System.out.println("Here's the recipt after paying with debit card");
	}
	
}

class CashPayMethod implements PayMethod {

	@Override
	public void doPayment() {
		System.out.println("Payment done via cash");
	}

	@Override
	public void getRecipt() {
		System.out.println("Here's the recipt after paying with cash");
	}
	
}