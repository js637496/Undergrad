import java.util.Scanner;

public class Exercise06_04 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		
		System.out.println("Enter an integer: ");
		n = input.nextInt();
		
		reverse(n);
	}
	public static void reverse(int number){
		String size = String.valueOf(number);
		
		String reverseString = new StringBuilder(size).reverse().toString();
		
		int reverse = Integer.parseInt(reverseString);
		
		System.out.println(reverse);
		
		
	}
}
