import java.util.Scanner;

public class Exercise04_09 {
	
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   int charNum;
		   char c;
		  
		   System.out.print("Enter an ASCII code:");
		   c = input.next().charAt(0);
		   
		   charNum = (int)c;
		   
		   System.out.println("The character for ASCII code " + c + " is " + charNum);
	}

}
