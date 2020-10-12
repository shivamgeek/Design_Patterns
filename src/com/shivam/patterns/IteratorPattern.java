package com.shivam.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 * Iterator Pattern
 * 
 * Iterator pattern provides a way to access an aggregated object sequentially without exposing its underlying implementation. 
 * 
 * It doesn't give whole list at once, instead provides one item at a time, so class has the encapsulation/data hiding benefit by not exposing
 * internal details.
 * Also, it provides lazy evaluation, so we can have infinite list theoretically so gets next element upon asking only. 
 * 
 */
public class IteratorPattern {

	public static void main(String[] args) {
		
		HouseItem table = new HouseItem("table");
		HouseItem chair = new HouseItem("chair");
		HouseItem television = new HouseItem("television");
		
		List<HouseItem> houseItems = new ArrayList<>();
		houseItems.add(table); houseItems.add(chair); houseItems.add(television);
		
		House house = new RealHouse(houseItems);
		
		HouseIterator iterator = house.getIterator();
		
		if(iterator.hasNextItem() == true) {
			System.out.println(iterator.nextItem().name);
		}

	}

}

class HouseItem {
	String name;
	public HouseItem(String name) {
		this.name = name;
	}
}

interface House {
	HouseIterator getIterator();
}

interface HouseIterator {
	
	boolean hasNextItem();
	HouseItem nextItem();
}

class RealHouse implements House {
	List<HouseItem> houseItems;
	
	public RealHouse(List<HouseItem> houseItems) {
		this.houseItems = houseItems;
	}
	
	public HouseIterator getIterator(){
		return new RealHouseIterator(this);
	}
	
}

class RealHouseIterator implements HouseIterator {
	
	RealHouse house;
	
	public RealHouseIterator(RealHouse house) {
		this.house = house;
	}
	
	@Override
	public boolean hasNextItem() {
		if(house.houseItems.size() != 0) { //just checking if size is 0 or not
			return true;
		}
		return false;
	}

	@Override
	public HouseItem nextItem() {
		return house.houseItems.get(0); //always returning 0 index element 
	} 
	
}





