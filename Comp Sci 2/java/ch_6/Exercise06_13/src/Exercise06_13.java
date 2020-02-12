import java.util.Scanner;

public class Exercise06_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner input = new Scanner(System.in);
		System.out.println("i\tm(i)");
		System.out.println("_______________");
		for(int i = 1; i <=20; i++){
			System.out.println(i + "\t" + printChars(i));
		}
	}
	
	public static double printChars(double num){
			double sum = 0;
			for(int i = 1; i <= num; i++){
		
				sum = sum + ((double)i/((double)i+1));
			}
		
		
		return sum;
		
	}

}
