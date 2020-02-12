import java.util.Scanner;

public class Exercise06_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//System.out.println("Enter 2 chars: ");
		//char ch1 = input.next().charAt(0);
		//char ch2 = input.next().charAt(0);
		//System.out.println("Enter number per line: ");
		//int num = input.nextInt();
		printChars('1', 'Z', 10);
	}
	
	public static void printChars(char ch1, char ch2, int numberPerLine){
		int count = 1;
		for(int i = ch1; i <= ch2; i++){
			System.out.print((char)i + " ");
			if(count % numberPerLine == 0)
				System.out.println();
			count++;
		}
	}

}
