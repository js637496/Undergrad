//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_16 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double side;
		System.out.print("Enter the side: ");
		side = input.nextDouble();
		System.out.println("The area of the hexagon is " + calcAreaHex(side));
		
	}
	
	public static double calcAreaHex(double side){
		return ((3 * Math.sqrt(3))/2) *Math.pow(side, 2);
	}
	
	
}