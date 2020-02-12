//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise06_07 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double investment, interest;
		//int years;
		System.out.print("Enter the investment amount: ");
		investment = input.nextDouble();
		System.out.print("Enter annual interest rate in percentage: ");
		interest = input.nextDouble();
		//System.out.print("Enter number of years: ");
		//years = input.nextInt();
		//double total = calcInterest(interest, years, interest) + investment;
		System.out.println("Years\tFuture Value");
	
		for(int i = 1; i <= 30; i++)
		{
			System.out.println(i + "\t" + futureInvestmentValue(investment, interest, i));
		}
		
		//System.out.println( calcInterest(investment, years, interest));
		
	}
	
	public static double futureInvestmentValue(double investment, double interest, int years){
		
			return investment*(Math.pow((1+(interest/1200)), (years*12)));
		
		
	
	}
	
}
