package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales ;
	private double averageSales ;
	private SalesSector[] team ;
	private int numOfMembers ;
	
	public static void main(String[] args) {
		//int numOfMembers = 0;
		//Scanner myScanner = new Scanner(System.in) ;
		

	}
	
	public void getData() {
		Scanner myScanner = new Scanner(System.in) ;
		
		System.out.print("Enter number of sales members : ");
		numOfMembers = myScanner.nextInt();
		
		team = new SalesSector[numOfMembers] ;
		
		for (int i = 0 ; i < this.team.length ; i++) {
			
			System.out.print("Enter data for member number " + (i + 1));
			System.out.print("Enter name of sales member : ");
			team[i].setName(myScanner.next()) ;
			System.out.print("Enter sales member's  Sales : ");
			team[i].setSales(myScanner.nextDouble()) ;
			
		}
		
		myScanner.close();
		
	}
	
	public void computeAverageSales() {
		
	}
	
	public void computeHighestSales() {
		
	}
	
	public void displayResult() {
		
	}

}
