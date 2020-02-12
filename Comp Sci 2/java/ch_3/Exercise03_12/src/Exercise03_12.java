import java.util.Scanner;

public class Exercise03_12 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String integer;
		int a, c,x;
		System.out.print("Enter a 3 digit number: ");
		integer = input.next();
		
		a = (int)Character.getNumericValue(integer.charAt(0));
		c = (int)Character.getNumericValue(integer.charAt(2));
		x = Integer.valueOf(integer);
		if(a == c)
			System.out.print(x + " is a palindrome");
		else
			System.out.print(x + " is not a palindrome");
		
	}
	
}

