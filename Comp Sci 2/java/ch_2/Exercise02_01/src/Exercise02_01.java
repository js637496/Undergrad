//Jim Speers
//1/31/2016
//CIS 164 Section 450

import java.util.Scanner;

public class Exercise02_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double celsius = 0;
		System.out.print("Enter a degree in Celsius: ");
		celsius = input.nextDouble();
		System.out.println(celsius + " Celsius is " + convertCToF(celsius) + " Fahrenheit");
	}
	
	public static double convertCToF(double celsius){
		double fahrenheit;
		fahrenheit = (9.0/5) * celsius + 32;
		return (fahrenheit);
	}

}
