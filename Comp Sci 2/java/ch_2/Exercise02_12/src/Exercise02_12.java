//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_12 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double a, v;
		System.out.print("Enter speed and acceleration: ");
		v = input.nextDouble();
		a = input.nextDouble();
		System.out.println("The minimum runway length for this airplane is " + runwayLength(v, a));
		
	}
	
	public static double runwayLength(double v, double a){
		return ((v*v)/(2*a));
	}
	
}