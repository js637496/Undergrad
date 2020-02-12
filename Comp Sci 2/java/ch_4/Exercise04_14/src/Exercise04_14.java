import java.util.Scanner;

public class Exercise04_14 {
	
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   char letter, letter2;
		  
		   System.out.print("Enter a hex digit: ");
		   letter = input.next().charAt(0);
		   
		   letter2 = Character.toUpperCase(letter);
		   
		   if(letter2 >= 65 && letter2 <= 70){ 
			   if(letter2 == 'A')
				   System.out.println("The numeric calue for grade " + letter + " 4");
			   if(letter2 == 'B')
				   System.out.println("The numeric calue for grade " + letter + " 3");
			   if(letter2 == 'C')
				   System.out.println("The numeric calue for grade " + letter + " 2");
			   if(letter2 == 'D')
				   System.out.println("The numeric calue for grade " + letter + " 1");
			   else
				   System.out.println("The numeric calue for grade " + letter + " 0");
		   }
		   else
			   System.out.println(letter + " is an invalid grade"); 
		 
	}

}
