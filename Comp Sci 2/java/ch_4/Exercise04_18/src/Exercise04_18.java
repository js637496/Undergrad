import java.util.Scanner;

public class Exercise04_18 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String ch;
		System.out.print("Enter two characters: ");
		ch = input.next();
		
		if((char)ch.charAt(0) == 'M'){
			if((char)ch.charAt(1) == '1'){
				System.out.println("Mathematics Freshman");
			}
			else if((char)ch.charAt(1) == '2'){
				System.out.println("Mathematics Sophomore");
			}
			else if((char)ch.charAt(1) == '3'){
				System.out.println("Mathematics Junior");			
			}
			else if((char)ch.charAt(1) == '4'){
				System.out.println("Mathematics Senior");
			}
			else{
				System.out.println("Invalid input");
			}
		}
		else if((char)ch.charAt(0) == 'C'){
			if((char)ch.charAt(1) == '1'){
				System.out.println("Computer Science Freshman");
			}
			else if((char)ch.charAt(1) == '2'){
				System.out.println("Computer Science Sophomore");
			}
			else if((char)ch.charAt(1) == '3'){
				System.out.println("Computer Science Junior");	
			}
			else if((char)ch.charAt(1) == '4'){
				System.out.println("Computer Science Senior");
			}
			else{
				System.out.println("Invalid input");
			}
		}
		else if((char)ch.charAt(0) == 'I'){
			if((char)ch.charAt(1) == '1'){
				System.out.println("Information Technology Freshman");
			}
			else if((char)ch.charAt(1) == '2'){
				System.out.println("Information Technology Sophomore");
			}
			else if((char)ch.charAt(1) == '3'){
				System.out.println("Information Technology Junior");			
			}
			else if((char)ch.charAt(1) == '4'){
				System.out.println("Information Technology Senior");
			}
			else{
				System.out.println("Invalid input");
			}
		}
		else{
			System.out.println("Invalid input");
		}
		
	}
	
}