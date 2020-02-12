//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_17 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double temp=42;
		double speed=-1;
		int count=0;
		while(temp > 41 || temp < -58){
		System.out.print("Enter the temperature in Fahrenheit between -58F and 41F: ");
		temp = input.nextDouble();
		}
		while(speed < 2){
			System.out.print("Enter the wind speed (>=2) in miles per hour: ");
			speed = input.nextDouble();
		}
		
		
		
		System.out.println("The wind chill index is " + calcWindChill(temp, speed));
		
	}
	
	public static double calcWindChill(double temp, double speed){
		return (35.74 + (0.6215 * temp) - (35.75 * Math.pow(speed, 0.16)) + (0.4275 * temp * Math.pow(speed, 0.16)));
	}
	
}