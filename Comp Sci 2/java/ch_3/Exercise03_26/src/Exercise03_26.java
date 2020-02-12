import java.util.Scanner;

public class Exercise03_26 {
	
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   int num;
		  
		   System.out.print("Enter an integer:");
		   num = input.nextInt();
		   
		   boolean fiveAndSix =  ((num % 5 == 0) && (num % 6 == 0));
		   boolean fiveOrSix =  ((num % 5 == 0) || (num % 6 == 0));
		   boolean fiveXOrSix =  ((num % 5 == 0) ^ (num % 6 == 0));
		   
		   System.out.println("Is " + num + " divisiable by 5 and 6? " + fiveAndSix);
		   System.out.println("Is " + num + " divisiable by 5 or 6? " + fiveOrSix);
		   System.out.println("Is " + num + " divisiable by 5 or 6, but not both? " + fiveXOrSix);
	}

}
