//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise03_09 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int d1, d2 , d3, d4, d5 , d6, d7, d8 , d9;
		//int nineISBN;
		int fullISBN;
		int x;
		String stringOfNineISBN;
		System.out.print("Enter the first 9 digits of a ISBN interger: ");
		stringOfNineISBN = input.next();
		
		d9 = (int)Character.getNumericValue(stringOfNineISBN.charAt(8));
		d8 = (int)Character.getNumericValue(stringOfNineISBN.charAt(7));
		d7 = (int)Character.getNumericValue(stringOfNineISBN.charAt(6));
		d6 = (int)Character.getNumericValue(stringOfNineISBN.charAt(5));
		d5 = (int)Character.getNumericValue(stringOfNineISBN.charAt(4));
		d4 = (int)Character.getNumericValue(stringOfNineISBN.charAt(3));
		d3 = (int)Character.getNumericValue(stringOfNineISBN.charAt(2));
		d2 = (int)Character.getNumericValue(stringOfNineISBN.charAt(1));
		d1 = (int)Character.getNumericValue(stringOfNineISBN.charAt(0));
		
		fullISBN = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;

		x = Integer.valueOf(stringOfNineISBN+ fullISBN) ;
		String formatted = String.format("%010d", x);

		if(fullISBN == 10)
			System.out.println("The ISBN-10 number is " + stringOfNineISBN + "X");
		else
			System.out.println("The ISBN-10 number is " + formatted);
	}
}
