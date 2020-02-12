//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_15 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double x1, y1, x2, y2;
		System.out.print("Enter x1 and y1: ");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		System.out.print("Enter x2 and y2: ");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		System.out.println("The distance between the two points is " + distance(x1, y1, x2, y2));
		
	}
	
	public static double distance(double x1, double y1, double x2, double y2){
		return (Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2))) ;
	}	
}