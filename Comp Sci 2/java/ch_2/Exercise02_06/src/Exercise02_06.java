//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_06 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int number=1001;
		int sum=0;
		int count=0;
		boolean looper = true;
		while(number > 1000 || number <0){
		System.out.print("Enter a number between 0 and 1000: ");
		number = input.nextInt();
		}
		
		while (looper){
			sum = sum + calcMod(number);
			number = number / 10;
			if(number / 10 == 0)
				count++;
			if(count == 2)
				looper = false;
		}
		
		System.out.println("The sum of the digits is " + sum);
		
	}
	
	public static int calcMod(int number){
		return (number % 10);
	}
	
}