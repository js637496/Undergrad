import java.util.Scanner;

public class Exercise04_25 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		char c1;
		char c2;
		char c3;
		String firstThree;
		int secondFour;
		c1 = (char)((int) (Math.random() * 25) + 65); 
		c2 = (char)((int) (Math.random() * 25) + 65); 
		c3 = (char)((int) (Math.random() * 25) + 65); 
		secondFour = (int)(Math.random() * 9999); 
		firstThree = c1 + "" + c2 + "" + c3;
		
		System.out.println(firstThree + secondFour);
		
	}
	
}