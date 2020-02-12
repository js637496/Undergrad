import java.util.Scanner;

public class Exercise03_31 {
	
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   double xRate;
		   int choice;
		   double amount;
		   
		  
		   System.out.print("Enter the exchange rate for dollars to RMB:");
		   xRate= input.nextDouble();
		   System.out.print("EEnter 0 to convert from dollars to RMB and 1 vice versa:");
		   choice= input.nextInt();
		   if (choice == 0){
			    System.out.print("Enter the dollar amount:");
		   		amount= input.nextDouble();
		   		System.out.println("$" + amount + " is " + amount * xRate + " yuan");
		   }
		   else{
			   System.out.print("Enter the RMB amount:");
		   		amount = input.nextDouble();
		   		System.out.println(amount + " yuan is $" + amount / xRate);
		   }
	}

}
