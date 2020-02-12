//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise03_08 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a, b , c;
		System.out.print("Enter three intergers: ");
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		if(a < b){
			System.out.println(a + " " + b + " " + c);
		}
		if(a > b){
			System.out.println(b + " " + a + " " + c);
		}
		if(a == b && a > c){
			System.out.println(b + " " + c + " " + a);
		}
		if(a == b && a == c){
			System.out.println(a + " " + b + " " + c);
		}
		
	}
}
