//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_07 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int minutes;
		System.out.print("Enter the number of minutes: ");
		minutes = input.nextInt();
		System.out.println(minutes + " minutes is apporximately " + (int)calcYears(minutes) + " and " + (int)calcDays(calcYears(minutes)) + " days");
		
	}
	
	public static double calcYears(int minutes){
		
		double years = (double)minutes/525600;
		
		return years;
		
	}
	public static double calcDays(double years){
		return (years - (int)years) * 365;
	}
	
}