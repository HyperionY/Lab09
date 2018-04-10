package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales ;
	private double averageSales ;
	private SalesSector[] team ;
	private int numOfMembers ;
	
	public static void main(String[] args) {
		
		SalesReporter reporter = new SalesReporter() ;
		
		reporter.getData() ;
		reporter.computeAverageSales() ;
		reporter.computeHighestSales() ;
		reporter.sortingByHighestSales() ;
		reporter.displayResult() ;

	}
	
	public void getData() {
		Scanner myScanner = new Scanner(System.in) ;
		
		System.out.print("Enter number of sales members : ");
		numOfMembers = myScanner.nextInt();
		team = new SalesSector[numOfMembers] ;
		
		//myScanner.nextLine();
		//System.out.print(team.length);
		for (int i = 0 ; i < team.length ; i++) {
			team[i] = new SalesSector() ;
			System.out.print("Enter data for member number " + (i + 1) + "\n");
			System.out.print("Enter name of sales member : ");
			
			myScanner.nextLine() ;
			//String callName = myScanner.nextLine() ;
			team[i].setName(myScanner.nextLine()) ;
			System.out.print("Enter sales member's  Sales : ") ;
			team[i].setSales(myScanner.nextDouble()) ;
			
		}
		
		myScanner.close();
		
	}
	
	public void computeAverageSales() {
		
		averageSales = 0.0 ;
		
		for (int i = 0 ; i < team.length ; i++) {
			averageSales += team[i].getSales() ;
		}
		
		averageSales = averageSales / (double)team.length ;
	}
	
	public void computeHighestSales() {
		
		highestSales = 0.0 ;
		
		for (int i = 0 ; i < team.length ; i++) {
			if (highestSales < team[i].getSales()) {
				highestSales = team[i].getSales();
			}
		}
		
	}
	
	public void sortingByHighestSales() {
		String cpName ;
		double tmp ;
		
		for (int target = 0 ; target < team.length - 1 ; target++) {
			//int target = i ;
			
			for (int i = target + 1 ; i < team.length ; i++) {
				if (team[target].getSales() < team[i].getSales()) {
					cpName = team[target].getName() ;
					tmp = team[target].getSales() ;
					
					team[target].setName(team[i].getName());
					team[target].setSales(team[i].getSales());
					
					team[i].setName(cpName);
					team[i].setSales(tmp);
				}
				
			}
			
		}
		
	}
	
	public void displayResult() {
		System.out.print("Average sales per members is " + averageSales + "\n") ;
		System.out.print("The highest sales figure is " + highestSales + "\n") ;
		System.out.print("The following had the highest sales: \n") ;
		System.out.print("Name : " + team[0].getName() + "\n") ;
		System.out.print("Sales : " + team[0].getSales() + "\n") ;
		System.out.print((highestSales - averageSales) + " above the average \n");
		
		System.out.print("The rest performed as follows : \n");
		for (int i = 1 ; i < team.length ; i++) {
			System.out.print("Name : " + team[i].getName() + "\n") ;
			System.out.print("Sales : " + team[i].getSales() + "\n") ;
			
			if (team[i].getSales() >= averageSales) {
				System.out.print((highestSales - averageSales) + " above the average \n");
			}
			else {
				System.out.print((averageSales - highestSales) + " below the average \n");
			}
		}
		
	}

}
