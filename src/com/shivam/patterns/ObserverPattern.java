package com.shivam.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 * Observer Pattern
 * This defines a one to many dependency between objects so that when one changes it's state, all of it's observers are notified.
 * 
 * It's a push model instead of pull based model by observers observing a subject for change in subjects state.
 * So observers need to register to subject, so that subject knows what observers to push the notification
 * It's a 1 : n model, where we have one subject vs many observers
 * 
 * 
 * 
 */


public class ObserverPattern {

	public static void main(String args[]) {
		
		WeatherStation weatherStation = new WeatherStation();
		
		Phone phone = new Phone(weatherStation);
		Laptop laptop = new Laptop(weatherStation);
		
		
		weatherStation.addObserver(phone);
		weatherStation.addObserver(laptop);
		
		weatherStation.updateTemperature("24'C");
		
	}
	
}

interface IObservable {
	List<IObserver> observers = new ArrayList<>();
	
	default void addObserver(IObserver ob) {
		observers.add(ob);
	}
	
	default void removeObserver(IObserver ob) {
		observers.remove(ob);
	}
	
	default void notifyObservers() {
		for(IObserver ob : observers) {
			ob.updateObserver();
		}
	}
}

interface IObserver {
	
	default void updateObserver() {
		System.out.println("Device: "+this.getClass().getName()+" : Subject state changed");
	}
}

class WeatherStation implements IObservable {
	
	String temperature;
	
	void updateTemperature(String temp) {
		temperature = temp;
		System.out.println("Temperature updated on station");
		notifyObservers();
	}
	
	String getTemperature() {
		return temperature;
	}
	
}

class Phone implements IObserver {
	
	WeatherStation station = null;  
	
	/*
	 * This is required so that once we get notification from station using observer pattern,
	 * the phone/laptop also need to call relevant methods from the station to get the data
	 */
	
	
	public Phone(WeatherStation station) {
		this.station = station;
	}
	
	public void displayData() {
		System.out.println("From Phone: Station temperature is "+station.getTemperature());
	}
	
	public void updateObserver() {
		displayData();
	}
	
}

class Laptop implements IObserver {
	WeatherStation station = null;
	
	public Laptop(WeatherStation station) {
		this.station = station;
	}
	
	public void displayData() {
		System.out.println("From Laptop: Station temperature is "+station.getTemperature());
	}
	
	public void updateObserver() {
		displayData();
	}
	
}