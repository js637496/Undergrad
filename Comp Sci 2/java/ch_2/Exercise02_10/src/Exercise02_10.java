//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double kiloWater, initialTemp, finalTemp;
		System.out.println("Enter the amount of water in kilograms: ");
		kiloWater= input.nextDouble();
		System.out.println("Enter the initial temperature: ");
		initialTemp= input.nextDouble();
		System.out.println("Enter the final temperature: ");
		finalTemp= input.nextDouble();
		
		System.out.println("The energy needed is " + calcEnergy(kiloWater, initialTemp, finalTemp));
		
	}
	
	public static double calcEnergy(double kiloWater, double initialTemp, double finalTemp){
		return (kiloWater * (finalTemp - initialTemp) * 4184);
	}
	
	
}