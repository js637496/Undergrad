//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_13 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double monthlySavings, months, interest;
		months = 6;
		interest = 5;
		System.out.print("Enter the monthly savings amount: ");
		monthlySavings = input.nextDouble();
		System.out.println("After the sixth month, the account value is $" + calcInterest(monthlySavings, months, interest));
		
	}
	
	public static double calcInterest(double monthlySavings, double months, double interest){
		double current=monthlySavings;
		for(int i=0; i<months; i++){
			current = current + monthlySavings + (current * (interest/1200));
		}
		return current-monthlySavings;
	}
	
}