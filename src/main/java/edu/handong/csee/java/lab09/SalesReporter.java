/**
 * actor : YooJungYeun
 * class : JavaProgramming 01
 * HW : Lab09.repoterOfSales
 */

package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales ;	// set the double variable highestSales to save the highest sales
	private double averageSales ;	// set the double variable averageSales to save the average of Sales
	private SalesSector[] team ;	// set the array SalesSector as team
	private int numOfMembers ;		// set the int variable numOfMembers to save how many members
	
	public static void main(String[] args) {
		
		SalesReporter reporter = new SalesReporter() ;	// set the class SalesReporter as repoter
		
		reporter.getData() ;	// run getData() method
		reporter.computeAverageSales() ;	// run computeAverageSales() method
		reporter.computeHighestSales() ;	// run computeHighestSales() method
		reporter.sortingByHighestSales() ;	// run sortingByHighestSales() method
		reporter.displayResult() ;	// run displayResult() method

	}
	
	public void getData() {
		Scanner myScanner = new Scanner(System.in) ;	// set the Scanner(System.in) as myScanner
		
		System.out.print("Enter number of sales members : ");	// print on the console as "Enter number of sales members : "
		numOfMembers = myScanner.nextInt();		// input the int value into numOfMembers variable
		team = new SalesSector[numOfMembers] ;	// set the array 'team' and the array length same numOfMembers value 
		
		for (int i = 0 ; i < team.length ; i++) {	// loop to time of team.length value
			team[i] = new SalesSector() ;		// set the team[i] area as class SalesSector
			System.out.print("Enter data for member number " + (i + 1) + "\n");		// print on the console as "Enter data for member number " + (i + 1) + "\n"
			System.out.print("Enter name of sales member : ");		// print on the console as "Enter name of sales member : "
			
			myScanner.nextLine() ;		// get the error, input the 'Enter' value into team[i].setName
			team[i].setName(myScanner.nextLine()) ;		// get the name into team[i].name variable
			System.out.print("Enter sales member's  Sales : ") ;	// print on the console as "Enter sales member's  Sales : "
			team[i].setSales(myScanner.nextDouble()) ;	// get the sales into team[i].sales variable
			
		}
		
		myScanner.close();	// free the activated memory to myScanner
		
	}
	
	public void computeAverageSales() {
		
		averageSales = 0.0 ;	// set the averageSales value as 0.0
		
		for (int i = 0 ; i < team.length ; i++) {	// loop to time of team.length value
			averageSales += team[i].getSales() ;	// plus the team[i].sales to averageSaels variable
		}
		
		averageSales = averageSales / (double)team.length ;		// divide the averageSales as team.length
	}
	
	public void computeHighestSales() {
		
		highestSales = 0.0 ;	// set the highestSales value as 0.0
		
		for (int i = 0 ; i < team.length ; i++) {	// loop to time of team.length value
			if (highestSales < team[i].getSales()) {
				highestSales = team[i].getSales();		// if team[i].sales value bigger than highestSales, set the highestSale as team[i].sales value
			}
		}
		
	}
	
	public void sortingByHighestSales() {
		String cpName ;		// set the String variable as cpName, it's mean as 'copyName'
		double tmp ;		// set the double variable as tmp
		
		for (int target = 0 ; target < team.length - 1 ; target++) {	// loop to time of team.length value - 1
			
			for (int i = target + 1 ; i < team.length ; i++) {		// loop target + 1 to team.length
				if (team[target].getSales() < team[i].getSales()) {		// if team[i].sales bigger than team[target].sales activate under lines
					cpName = team[target].getName() ;		// set the cpName as team[target].name value
					tmp = team[target].getSales() ;			// set the cpName as team[target].sales value
					
					team[target].setName(team[i].getName());		// set the team[target].name as team[i].name value
					team[target].setSales(team[i].getSales());		// // set the team[target].sales as team[i].sales value
					
					team[i].setName(cpName);		// set the team[i].name as cpName value
					team[i].setSales(tmp);			// set the team[i].sales as tmp value
				}
				
			}
			
		}
		
	}
	
	public void displayResult() {
		System.out.print("Average sales per members is " + averageSales + "\n") ;		// print out string in the "" on console, it's print the average of sales
		System.out.print("The highest sales figure is " + highestSales + "\n") ;		// print out string in the "" on console, it's print the highest of sales
		System.out.print("The following had the highest sales: \n") ;		// print out string in the "" on console
		System.out.print("Name : " + team[0].getName() + "\n") ;		// print out string in the "" on console, it's print the highest salesmen name
		System.out.print("Sales : " + team[0].getSales() + "\n") ;		// print out string in the "" on console, it's print the highest salesmen sales
		System.out.print((highestSales - averageSales) + " above the average \n");		// print out string in the "" on console, it's print difference salesmen's sales and average
		
		System.out.print("The rest performed as follows : \n");		// print out string in the "" on console
		for (int i = 1 ; i < team.length ; i++) {		// loop to time of team.length value
			System.out.print("Name : " + team[i].getName() + "\n") ;	// print out string in the "" on console, it's print the highest salesmen name
			System.out.print("Sales : " + team[i].getSales() + "\n") ;	// print out string in the "" on console, it's print the highest salesmen sales
			
			if (team[i].getSales() >= averageSales) {	// if team[i].sales bigger or same than averageSale activate under line
				System.out.print((highestSales - averageSales) + " above the average \n");	// print out string in the "" on console, it's print difference salesmen's sales and average
			}
			else {	// if team[i].sales smaller than averageSale activate under line
				System.out.print((averageSales - highestSales) + " below the average \n");	// print out string in the "" on console, it's print difference salesmen's sales and average
			}
		}
		
	}

}
