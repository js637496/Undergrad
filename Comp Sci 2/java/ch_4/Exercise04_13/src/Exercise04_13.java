import java.util.Scanner;

public class Exercise04_13 {
	
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   char letter, letter2;
		  
		   System.out.print("Enter a hex digit: ");
		   letter = input.next().charAt(0);
		   
		   letter2 = Character.toUpperCase(letter);
		   
		   if(letter2 >= 65 && letter2 <= 90){ 
			   if(letter2 == 'A' || letter2 == 'E' || letter2 == 'I' || letter2 == 'O' || letter2 == 'U')
				   System.out.println(letter + " is a vowel");
			   else
				   System.out.println(letter + " is a consonant");
		   }
		   else
			   System.out.println(letter + " is an invlaid input"); 
		 
	}

}
