package com.shivam.SOLID;

/*
 * Interface Segregation Principle
 * 
 * No client should be forced to depend on methods it doesn't use.
 * One fat interface needs to be split into many smaller and relevant interfaces so that clients can 
 * use interfaces that are relevant to them.
 * 
 * 
 * 
 */

public class InterfaceSegregationPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 *Before ISP
 */

interface IPrintTasks {
	void printContent(String content);
	void scanContent(String content);
	void faxContent(String content);
	void photoCopyContent(String content);
	void connectToWifi(String wifiName);
}

// All printer implementations are forced to use all methods even if they don't have that functionality.

/*
 * After ISP
 */

interface IBasicPrintTasks {
	void printContent(String content);
	void scanContent(String content);
	void photoCopyContent(String content);
	
}

interface IFaxTask {
	void faxContent(String content);
}

interface IModernPrinterTasks extends IBasicPrintTasks {
	void connectToWifi(String wifiName);
}




