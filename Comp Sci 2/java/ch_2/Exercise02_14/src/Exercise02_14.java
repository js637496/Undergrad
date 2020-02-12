//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_14 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double pounds, inches;
		System.out.print("Enter weight in pounds: ");
		pounds = input.nextDouble();
		System.out.print("Enter height in inches: ");
		inches = input.nextDouble();
		System.out.println("BMI is" + calcBMI(pounds, inches));
		
	}
	
	public static double calcBMI(double pounds, double inches){
		double toKilo = pounds * 0.45359237;
		double toMeter = inches * 0.0254;
		return (toKilo/(toMeter*toMeter));
	}

}