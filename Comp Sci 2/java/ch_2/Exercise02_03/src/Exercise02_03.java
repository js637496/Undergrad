//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double feet;
		System.out.print("Enter a value for feet: ");
		feet = input.nextDouble();
		System.out.println(feet + " feet is " + calcMeters(feet) + " meters");
		
	}
	
	public static double calcMeters(double feet){
		return (feet * 0.305);
	}
	
}
