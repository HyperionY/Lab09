package edu.handong.csee.java.lab09;

public class SalesSector {
	private String name ;		// set the String variable as name
	private double sales ;		// set the double variable as sales
	
	public void setName(String name) {
		this.name = name ;		// input the name to SalesSector.name
	}
	
	public void setSales(double sales) {
		this.sales = sales ;	// input the sales to SalesSector.sales
	}
	
	public String getName() {
		return this.name ;		// return the SalesSector.name value
	}
	
	public double getSales() {
		return this.sales ;		// return the SalesSector.sales value
	}
}
