import java.util.Scanner;

public class Exercise04_23 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String name;
		double hoursWorked, hourlyRate, fed, state;
		
		System.out.print("Enter an Employees name: ");
		name = input.nextLine();
		System.out.print("Enter number of hours worked in a week: ");
		hoursWorked = input.nextDouble();
		System.out.print("Enter hourly pay rate: ");
		hourlyRate = input.nextDouble();
		System.out.print("Enter federal tax withholding rate: ");
		fed = input.nextDouble();
		System.out.print("Enter state tax withholding rate: ");
		state = input.nextDouble();;
		
		System.out.println("Employee Name: " + name);
		System.out.println("Hours Worked: " + hoursWorked);
		System.out.println("Pay Rate: $" + hourlyRate);
		System.out.println("Gross Pay: $" + hourlyRate * hoursWorked);
		System.out.println("Deductions:");
		System.out.println("\tFederal Withholding (" + fed * 100 + "%): $" + fed * hourlyRate * hoursWorked);
		System.out.println("\tState Withholding (" + state * 100 + "%): $" + state * hourlyRate * hoursWorked);
		System.out.println("\tTotal Deduction: $" + ((state * hourlyRate * hoursWorked) + (fed * hourlyRate * hoursWorked)));
		System.out.println("Ney Pay: $" + ((hourlyRate * hoursWorked) - ((state * hourlyRate * hoursWorked) + (fed * hourlyRate * hoursWorked))));
	}
	
}