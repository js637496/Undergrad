import java.util.Scanner;

public class Exercise04_12 {
	
	private static final String NULL = null;

	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   char hex;
		   String formating;
		  
		   System.out.print("Enter a hex digit: ");
		   hex = input.next().charAt(0);
		   
		   System.out.println(hex);
		   
		   int convert = Character.digit(hex,16);
		   
		   formating = Integer.toBinaryString(convert);
		   
		  // formating = String.format("%04d", formating);
		   
		   if(convert < 0)
			   System.out.println(hex + " is an invalid input");
		   else
			   System.out.println("The binary value is " + formating);
	}

}
