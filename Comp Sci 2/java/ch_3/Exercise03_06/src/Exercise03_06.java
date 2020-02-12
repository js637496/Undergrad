//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise03_06 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double pounds, inches , feet;
		System.out.print("Enter weight in pounds: ");
		pounds = input.nextDouble();
		System.out.print("Enter feet: ");
		feet = input.nextDouble();
		System.out.print("Enter inches: ");
		inches = input.nextDouble();
		System.out.println("BMI is " + calcBMI(pounds, inches, feet));
		
	}
	
	public static double calcBMI(double pounds, double inches, double feet){
		double feetToMeter = feet * 12 * 0.0254;
		double toKilo = pounds * 0.45359237;
		double toMeter = inches * 0.0254;
		double totalHeight = toMeter + feetToMeter;
		return (toKilo/(totalHeight*totalHeight));
	}

}