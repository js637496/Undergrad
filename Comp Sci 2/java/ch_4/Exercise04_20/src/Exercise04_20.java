import java.util.Scanner;

public class Exercise04_20 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String ch;
		char ch1;
		int length;
		System.out.print("Enter a string: ");
		ch = input.nextLine();
		
		ch1 = (char)ch.charAt(0);
		length = ch.length();
		
		System.out.println("The length of the string is " + length);
		System.out.println("The first character in the string is " + ch1);
		
	}
	
}