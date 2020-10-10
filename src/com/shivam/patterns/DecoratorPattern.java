package com.shivam.patterns;

/* Decorator Pattern
 * 
 * Decorator pattern attaches extra responsibility to the object dynamically and extends its functionality.
 * Instead of interacting with a object directly, that is calling a method directly and getting result
 * we decorate the object, we put a wrapper around the object, so we directly interact with the wrapper/decorator
 * and that wrapper/decorator in turn interacts with the object.
 * To facilitate this decorator/wrapper must be the same type as the object itself ie they're exchangeable.
 * The wrapper/decorator resembles both IS-A and HAS-A relationship with the object ie we use both inheritance and composition.
 * 
 * Inheritance is used to ensure wrapper is same type as Object, and composition takes care of sharing behaviour.
 * 
 */

public class DecoratorPattern {

	public static void main(String args[]) {
		
		FlightSeatAddonDecorator seat = new Wifi(new HeadPhones(new ExtraMeal(new IndigoFlight())));
		
		System.out.println("Total cost is "+seat.calculateCost());
		System.out.println("DESCRIPTION: "+seat.seatDetails());
		
	}
	
}


interface FlightSeat {
	int seatNo = 0;
	double cost = 0;
	double calculateCost();
	String seatDetails();
}

abstract class FlightSeatAddonDecorator implements FlightSeat {
	FlightSeat flightSeat = null;
}

class IndigoFlight implements FlightSeat {
	@Override
	public double calculateCost() {
		return 500;
	}

	@Override
	public String seatDetails() {
		return "This is Indigo airline seat";
	}
}

class AirAsia implements FlightSeat {
	@Override
	public double calculateCost() {
		return 700;
	}

	@Override
	public String seatDetails() {
		return "This is AirAsia airline seat";
	}
}

class Wifi extends FlightSeatAddonDecorator {
	
	public Wifi(FlightSeat seat) {
		flightSeat = seat;
	}

	@Override
	public double calculateCost() {
		return 100 + flightSeat.calculateCost();
	}

	@Override
	public String seatDetails() {
		return flightSeat.seatDetails()+ " You get Wifi with this addon";
	}
	
}

class ExtraMeal extends FlightSeatAddonDecorator {
	
	public ExtraMeal(FlightSeat seat) {
		flightSeat = seat;
	}
	
	@Override
	public double calculateCost() {
		return 400  + flightSeat.calculateCost();
	}

	@Override
	public String seatDetails() {
		return flightSeat.seatDetails()+ " You get ExtraMeal with this addon";
	}
	
}

class HeadPhones extends FlightSeatAddonDecorator {
	
	public HeadPhones(FlightSeat seat) {
		flightSeat = seat;
	}
	
	@Override
	public double calculateCost() {
		return 200 + flightSeat.calculateCost();
	}

	@Override
	public String seatDetails() {
		return flightSeat.seatDetails()+ " You get Headphones with this addon";
	}
	
}






