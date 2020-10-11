package com.shivam.patterns;

/*
 * Proxy Pattern
 * 
 * Proxy pattern provides a surrogate or placeholder for another object to control access to it.
 * 
 * Insted of interacting with the object directly, you interact or use the proxy which in turn uses the object class.
 * The proxy looks like the original object itself.
 * 
 * There are 3 ways to implement proxy - 
 * 1. Remote proxy - When interaction needs to happen with something outside the scope of the project or from the outside world. 
 * 					 Remote resource such as something from a server
 * 2. Virtual proxy - It controls access to a resource that's expensive to create.
 * 3. Protection proxy - It controls access to a resource, based on access rights.
 * 
 * Here creating a TextBookParser, third-party library is an expensive operation, as it does pre-computations.
 * Futher utility method calls are fast because of the pre-computation. 
 * 
 * But it's not guaranteed that other utility methods will definitely be invoked, so we want to do expensive pre-computation only in case
 * utility methods will be called, so we want to defer it, make it LAZY, 
 * 
 * a> Proxy controls access to real object
 * b> Proxy follows the same interface as the real object
 * c> Proxy instantiates the real subject in case instantiation is costly
 */

public class ProxyPattern {

	public static void main(String[] args) {
		
		Book book = new Book("SOME HUGE HUGE STRING DATA");
		
		BookParser parser = new TextBookParser(book); // Time consuming task as it does precomputation
		
		//Fast operations are pre-computations are already done
		System.out.println("Number of chapters are "+parser.calculateNumChapters());
		System.out.println("Number of pages are "+parser.calculateNumPages());
		
		
		/* Now using proxy pattern, first call is cheap */
		BookParser proxyParser = new ProxyBookParser(book);
		
		System.out.println("Number of chapters are "+proxyParser.calculateNumChapters());
		System.out.println("Number of pages are "+proxyParser.calculateNumPages());

	}

}


class Book {
	String author;
	String data;
	
	public Book(String data) {
		this.data = data;
	}
}

interface BookParser {
	int calculateNumPages();
	int calculateNumChapters();
}

class TextBookParser implements BookParser{
	Book book;
	private int numPages;
	private int numChapters;
	
	public TextBookParser(Book book) {
		this.book = book;
		//doing some pre-processing here so that creation of BookParser object is heavy/time-consuming/costly.
		try { Thread.sleep(2000); } catch(Exception e) { e.printStackTrace(); }
	}
	
	public int calculateNumPages() {
		return numPages;
	}
	
	public int calculateNumChapters() {
		return numChapters;
	}
}


class ProxyBookParser implements BookParser {
	Book book;
	
	private TextBookParser textBookParser;
	
	public ProxyBookParser(Book book) { //cheap as compared to TextBookParser
		this.book = book;
	}
	
	//Instantiation only happens when we actually want to use the utility methods
	public int calculateNumPages() {
		if(textBookParser == null) {
			textBookParser = new TextBookParser(book);
			try { Thread.sleep(2000); } catch(Exception e) { e.printStackTrace(); }
		}
		return textBookParser.calculateNumPages();
	}
	
	public int calculateNumChapters() {
		if(textBookParser == null) {
			textBookParser = new TextBookParser(book);
			try { Thread.sleep(2000); } catch(Exception e) { e.printStackTrace(); }
		}
		return textBookParser.calculateNumChapters();
	}
}