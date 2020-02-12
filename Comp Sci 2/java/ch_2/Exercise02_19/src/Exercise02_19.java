//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_19 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double x1, y1, x2, y2, x3, y3;
		System.out.print("Enter three points for a triangle: ");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
		System.out.println("The area of the triangle is " + areaTriable(x1, y1, x2, y2, x3, y3));
		
	}
	
	public static double areaTriable(double x1, double y1, double x2, double y2, double x3, double y3){
		double s1, s2, s3, s, area;
		s1 = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
		s2 = Math.sqrt(Math.pow(x3-x1,2) + Math.pow(y3-y1,2));
		s3 = Math.sqrt(Math.pow(x3-x2,2) + Math.pow(y3-y2,2));
		
		s = (s1+s2+s3)/2;
		
		area = Math.sqrt(s * (s - s1) * (s - s2) * (s -s3));
		
		return area;
	}	
}