/**
 * actor : YooJungYeun
 * class : JavaProgramming 01
 * HW : Lab09.repoterOfSales
 */

package edu.handong.csee.java.lab09;

import java.util.ArrayList;
import java.util.Scanner;

public class SalesReporter {
	private double highestSales ;	// set the double variable highestSales to save the highest sales
	private double averageSales ;	// set the double variable averageSales to save the average of Sales
	private ArrayList<SalesSector> team ;	// set the arrayList SalesSector as team
	
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
		team = new ArrayList<SalesSector>() ;	// set the array 'team' and the array size same numOfMembers value 
		
		boolean done = false ;	// set the boolean variable to use escape the while loop
		int count = 0 ;		// the analyze the number of team's size
		
		while (!done) {		// loop under lines until if done value is true
			SalesSector men = new SalesSector() ;	// set the new SalesSector() as men
			
			System.out.print("Enter data for member number " + (count + 1) + "\n");		// print on the console as "Enter data for member number " + (count + 1) + "\n"
			System.out.print("Enter name of sales member : ");		// print on the console as "Enter name of sales member : "
			men.setName(myScanner.nextLine()) ;		// get the name into men.name variable
			System.out.print("Enter sales member's  Sales : ") ;	// print on the console as "Enter sales member's  Sales : "
			men.setSales(myScanner.nextDouble()) ;		// get the sales into men.sales variable
			team.add(men) ;
			
            System.out.print ("More items for the list? : ");		// print on the console to ask keep try input the salesmen data
            myScanner.nextLine() ;		// get the error, input the 'Enter' value into ans(it's purpose, get the string "yes" or "no"
            String ans = myScanner.nextLine ();		// get the answer into ans
            if (!ans.equalsIgnoreCase ("yes")) done = true;		// if ans value isn't 'yes', change done value as true
            count++ ;		// add 1 to count variable
            
		}
		
		myScanner.close();	// free the activated memory to myScanner
		
	}
	
	public void computeAverageSales() {
		
		averageSales = 0.0 ;	// set the averageSales value as 0.0
		
		for (int i = 0 ; i < team.size() ; i++) {	// loop to time of team.size value
			averageSales += (team.get(i)).getSales() ;	// add the team(i).sales to averageSaels variable
		}
		
		averageSales = averageSales / (double)team.size() ;		// divide the averageSales as team.size
	}
	
	public void computeHighestSales() {
		
		highestSales = 0.0 ;	// set the highestSales value as 0.0
		
		for (int i = 0 ; i < team.size() ; i++) {	// loop to time of team.size value
			if (highestSales < (team.get(i)).getSales()) {
				highestSales = (team.get(i)).getSales();		// if team(i).sales value bigger than highestSales, set the highestSale as team(i).sales value
			}
		}
		
	}
	
	public void sortingByHighestSales() {
		String cpName ;		// set the String variable as cpName, it's mean as 'copyName'
		double tmp ;		// set the double variable as tmp
		
		for (int target = 0 ; target < team.size() - 1 ; target++) {	// loop to time of team.size value - 1
			
			for (int i = target + 1 ; i < team.size() ; i++) {		// loop target + 1 to team.size
				if ((team.get(target)).getSales() < (team.get(i)).getSales()) {		// if team(i).sales bigger than team(target).sales activate under lines
					cpName = (team.get(target)).getName() ;		// set the cpName as team(target).name value
					tmp = (team.get(target)).getSales() ;			// set the cpName as team(target).sales value
					
					(team.get(target)).setName((team.get(i)).getName());		// set the team(target).name as team(i).name value
					(team.get(target)).setSales((team.get(i)).getSales());		// // set the team(target).sales as team(i).sales value
					
					(team.get(i)).setName(cpName);		// set the team(i).name as cpName value
					(team.get(i)).setSales(tmp);			// set the team(i).sales as tmp value
				}
				
			}
			
		}
		
	}
	
	public void displayResult() {
		System.out.print("Average sales per members is " + averageSales + "\n") ;		// print out string in the "" on console, it's print the average of sales
		System.out.print("The highest sales figure is " + highestSales + "\n") ;		// print out string in the "" on console, it's print the highest of sales
		System.out.print("The following had the highest sales: \n") ;		// print out string in the "" on console
		System.out.print("Name : " + (team.get(0)).getName() + "\n") ;		// print out string in the "" on console, it's print the highest salesmen name
		System.out.print("Sales : " + (team.get(0)).getSales() + "\n") ;		// print out string in the "" on console, it's print the highest salesmen sales
		System.out.print((highestSales - averageSales) + " above the average \n");		// print out string in the "" on console, it's print difference salesmen's sales and average
		
		System.out.print("The rest performed as follows : \n");		// print out string in the "" on console
		for (int i = 1 ; i < team.size() ; i++) {		// loop to time of team.size value
			System.out.print("Name : " + (team.get(i)).getName() + "\n") ;	// print out string in the "" on console, it's print the highest salesmen name
			System.out.print("Sales : " + (team.get(i)).getSales() + "\n") ;	// print out string in the "" on console, it's print the highest salesmen sales
			
			if ((team.get(i)).getSales() >= averageSales) {	// if team(i).sales bigger or same than averageSale activate under line
				System.out.print((highestSales - averageSales) + " above the average \n");	// print out string in the "" on console, it's print difference salesmen's sales and average
			}
			else {	// if team(i).sales smaller than averageSale activate under line
				System.out.print((averageSales - highestSales) + " below the average \n");	// print out string in the "" on console, it's print difference salesmen's sales and average
			}
		}
		
	}

}
