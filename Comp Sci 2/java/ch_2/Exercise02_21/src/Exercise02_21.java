//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_21 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double investment, years, interest;
		System.out.print("Enter the investment amount: ");
		investment = input.nextDouble();
		System.out.print("Enter annual interest rate in percentage: ");
		interest = input.nextDouble();
		System.out.print("Enter number of years: ");
		years = input.nextDouble();
		//double total = calcInterest(interest, years, interest) + investment;
		System.out.println("Accumulated value is $" + calcInterest(investment, years, interest));
		
		//System.out.println( calcInterest(investment, years, interest));
		
	}
	
	public static double calcInterest(double investment, double years, double interest){
		
		return investment*(Math.pow((1+(interest/1200)), (years*12)));
	
	}
	
}