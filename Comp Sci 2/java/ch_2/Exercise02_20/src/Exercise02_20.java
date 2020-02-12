//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_20 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double balance, interest;
		interest = 5;
		System.out.print("Enter balance and interest rate: ");
		balance = input.nextDouble();
		interest = input.nextDouble();
		System.out.println("The interest is $" + calcInterest(balance, interest));
		
	}
	
	public static double calcInterest(double balance, double interest){
		
		return balance * (interest/1200);
	}
	
}