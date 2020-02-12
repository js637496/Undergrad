//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_18 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		float a = 1, b=2;
		System.out.println("a\tb\tpow(a, b)");
		for(int i = 0;i<6; i++){
			System.out.println((int)a+"\t"+(int)b+"\t"+(int)Math.pow(a, b));
			a++;
			b++;
		}
		
	}
	
}