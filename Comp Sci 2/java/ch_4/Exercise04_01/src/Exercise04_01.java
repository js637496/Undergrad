import java.util.Scanner;

public class Exercise04_01 {
	
	public static void main(String[] args) {
		   Scanner input = new Scanner(System.in);
		   double r, s, a;
		   
		  
		   System.out.print("Enter the length from the cetner to a vertex:");
		   r = input.nextDouble();
		   
		   s = 2 * r * Math.sin(Math.PI / 5);
		   
		   a = (5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5));
		   
		   System.out.println("The area of the pentagon is " + a);
	}

}
