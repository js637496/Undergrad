import java.util.Scanner;

public class Exercise06_08 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Celsius\tFahrenheit\t|\tFahrenheit\tCelsius");
		System.out.println("________________________________________________________");
		double c = 40.0;
		double f = 120.0;
		for(int i = 40; i >= 31; i--){
			System.out.println(c +"\t" + celsiusToFahrenheit(c) + "\t|\t" + f + "\t" + fahrenheitToCelsius(f));
			c = c - 1;
			f = f - 10;
		}
		
	}

	/** Convert from Celsius to Fahrenheit */

	public static double celsiusToFahrenheit(double celsius){
		return ((9.0 / 5) * celsius + 32);
	}

	/** Convert from Fahrenheit to Celsius */

	public static double fahrenheitToCelsius(double fahrenheit){
		return ((5.0 / 9) * (fahrenheit - 32));
	}

}
