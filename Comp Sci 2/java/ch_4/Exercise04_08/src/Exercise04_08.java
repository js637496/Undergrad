import java.util.Scanner;

public class Exercise04_08 {
	
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   int charNum;
		   char c;
		  
		   System.out.print("Enter an ASCII code:");
		   charNum = input.nextInt();
		   
		   c = (char)charNum;
		   
		   System.out.println("The character for ASCII code " + charNum + " is " + c);
	}

}
