package com.shivam.patterns;

/*
 * Adapter Pattern
 * 
 * Adapter pattern converts the interface of one class, into another interface the class expects.
 * It lets classes work together which couldn't otherwise because of incompatibility.
 * 
 * Useful for having interactions between two non-compatible interfaces.
 * 
 * It's important to note that Adapter doesn't change the behavior in any way, neither adds or removes functionality it just simply
 * calls the other behavior.
 * If behavior change is what we're aiming at then we might need to use Decorator pattern.
 * 
 * Adapter is a concrete class that implements the Clients interface functionality but then internally within that implementation calls
 * the other interface methods.
 * 
 */

public class AdapterPattern {

	public static void main(String[] args) {
		
		WeatherStationCenter station = new WeatherStationCenter();
		Database db = new Database();
		
		/* This call is deprecated now, as data is returned in JSON instead for XML */
		/* So we either change format everywhere in db, or use an Adapter */
		
		//XMLFormat data = station.getTemperatureData();
		//db.storeData(data);
		
		JSONFormat data = station.getTemperatureData();
		DatabaseAdapter dbAdapter = new DatabaseAdapter(db);
		
		
		dbAdapter.storeData(data);
		
	}

}

interface DataFormat { }

class XMLFormat implements DataFormat {
	String data = null;
	String name = "XML";
	public XMLFormat(String data) {
		this.data = data;
	}
}

class JSONFormat implements DataFormat {
	String name = "JSON";
	String data;
	public JSONFormat(String data) {
		this.data = data;
	}
}

// WeatherStation started returning temperature data in JSON format recently, as opposed to XML previously 
class WeatherStationCenter {
	
	JSONFormat getTemperatureData() {
		return new JSONFormat("24'C, Sunny, Min Temp: 20, Max Temp: 28");
	}
	
}

interface IDatabase {
	void storeData(DataFormat data);
	DataFormat getData();
	void updateData(DataFormat data);
}

//Database stores data in XML Format
class Database  implements IDatabase {
	public void storeData(DataFormat data){
		System.out.println("Data stored in Database in XML Format");
	}

	@Override
	public DataFormat getData() {
		return new XMLFormat("Data from DB :: 24'C, Sunny, Min Temp: 20, Max Temp: 28");
	}

	@Override
	public void updateData(DataFormat data) {
		System.out.println("Data updated in Database in XML Format");
	}
}

/*
 * Previously WeatherStationCenter used to return XML data and we could store XML in our database directly.
 * Now, it starts returning JSON data, so we need to use a adapter for this JSON to XML conversion
 */

class DatabaseAdapter implements IDatabase {

	Database database;
	
	public DatabaseAdapter(Database db) {
		database = db;
	}
	
	@Override
	public void storeData(DataFormat data) {
		data = convertJsonToXml(data);
		database.storeData(data);
	}

	@Override
	public DataFormat getData() {
		return database.getData();
	}

	@Override
	public void updateData(DataFormat data) {
		data = convertJsonToXml(data);
		database.updateData(data);
	}
	
	private DataFormat convertJsonToXml(DataFormat data) {
		System.out.println("Converting JSON data to XML for storing in db");
		return new XMLFormat("Newly converted JSON to XML data");
	}
}





