import java.util.Scanner;
import java.util.*;

public class Exercise05_21 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double amount, years, rate=5;
		double hold;
                String s;
		
		System.out.println("Enter amount: ");
		amount = input.nextDouble();
		
		System.out.println("Enter years: ");
		years = input.nextDouble();
		
		System.out.println("Interest Rate\tMonthly Payment\t Total Payment");
		while(rate<=8){
            s = String.format("%.3f", rate);
			System.out.printf(s);
                        System.out.print("%");
			System.out.print("\t");
                       s =String.format("%.2f", (amount*(rate/12/100)) / (1-Math.pow(1+(rate/12/100), -years*12))); 
			System.out.printf(s);
			System.out.print("\t");
			hold = (amount*(rate/12/100)) / (1-Math.pow(1+(rate/12/100), -years*12));
                          s = String.format("%.2f", amount+(hold*12*years));
			System.out.printf(s);
			rate= rate +0.125;
			System.out.println();
		}
		
		double monthlyPayment = 
		         (amount*(rate/12/100)) / 
		            (1-Math.pow(1+(rate/12/100), -years*12));
		System.out.println(monthlyPayment);
   
	}
}
