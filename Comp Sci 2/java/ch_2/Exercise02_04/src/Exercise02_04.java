//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_04 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double pounds;
		System.out.print("Enter a number in pounds: ");
		pounds = input.nextDouble();
		System.out.println(pounds + " pounds is " + calcKilo(pounds) + " kilograms");
		
	}
	
	public static double calcKilo(double pounds){
		return (pounds * 0.454);
	}
	
}