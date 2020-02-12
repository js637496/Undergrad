//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double area, radius, length;
		System.out.print("Enter the radius and length of a cylinder: ");
		radius = input.nextDouble();
		length = input.nextDouble();
		area = calcArea(radius);
		System.out.println("The area is " + area);
		System.out.println("The volume is " + calcVolume(area, length));
		
	}
	
	public static double calcArea(double radius){
		return (radius * radius * Math.PI);
	}
	public static double calcVolume(double area, double length){
		return (area * length);
	}
}
