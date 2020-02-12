import java.util.Scanner;

public class Exercise06_05 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double n1, n2, n3;
		
		System.out.println("Enter an integer: ");
		n1 = input.nextDouble();
		n2 = input.nextDouble();
		n3 = input.nextDouble();
		
		displaySortedNumbers(n1, n2, n3);
	}
	public static void displaySortedNumbers(double num1, double num2, double num3){
		double temp;
		
		if(num1 > num2){
			temp = num2;
			num2 = num1;
		}
		if(num2 > num3){
			temp = num3;
			num3 = num2;
		}
		if(num1 > num3){
			temp = num3;
			num3 = num1;
		}
			
		System.out.println(num1 + " " + num2 + " " + num3);
	}
}
