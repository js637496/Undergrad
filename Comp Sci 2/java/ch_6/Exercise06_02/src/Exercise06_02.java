import java.util.Scanner;

public class Exercise06_02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n;
		
		System.out.println("Enter an integer: ");
		n = input.nextLong();
		
		System.out.println(sumDigits(n));
	}
	public static int sumDigits(long n){
		long sum = 0;
		String size = String.valueOf(n);
		for (int i = 0; i < size.length(); i++){
			sum = sum + (n % 10);
			n = n / 10;
		}
		
		
		return (int)sum;
	}
}
