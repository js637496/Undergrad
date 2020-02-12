import java.util.Scanner;

public class Exercise04_15 {
	
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   char letter, letter2;
		  
		   System.out.print("Enter a hex digit: ");
		   letter = input.next().charAt(0);
		   
		   letter2 = Character.toUpperCase(letter);
		   
		   if(letter2 >= 65 && letter2 <= 90){ 
			   if(letter2 == 'A' || letter2 == 'B' || letter2 == 'C')
				   System.out.println("The corresponding number is 2");
			   else if(letter2 == 'D' || letter2 == 'E' || letter2 == 'F')
					   System.out.println("The corresponding number is 3");
			   else if(letter2 == 'G' || letter2 == 'H' || letter2 == 'I')
				   System.out.println("The corresponding number is 4");
			   else if(letter2 == 'J' || letter2 == 'K' || letter2 == 'L')
				   System.out.println("The corresponding number is 5");
			   else if(letter2 == 'M' || letter2 == 'N' || letter2 == 'O')
				   System.out.println("The corresponding number is 6");
			   else if(letter2 == 'P' || letter2 == 'Q' || letter2 == 'R' || letter2 == 'S')
				   System.out.println("The corresponding number is 7");
			   else if(letter2 == 'T' || letter2 == 'U' || letter2 == 'V')
				   System.out.println("The corresponding number is 9");
			   else if(letter2 == 'W' || letter2 == 'X' || letter2 == 'Y' || letter2 == 'Z')
				   System.out.println("The corresponding number is 9");
		   }
		   else
			   System.out.println(letter + " is an invalid input"); 
		 
	}

}