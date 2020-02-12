//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_09 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double v0, v1, t;
		System.out.print("Enter v0, v1 and t: ");
		v0 = input.nextDouble();
		v1 = input.nextDouble();
		t = input.nextDouble();
		System.out.println("the average acceleration is " + calcAcceleration(v0, v1, t));
		
	}
	
	public static double calcAcceleration(double v0, double v1, double t){
		return ((v1-v0)/t);
	}
	
	
}