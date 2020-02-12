import java.util.Scanner;

public class Exercise04_24 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String city1, city2, city3;
		System.out.print("Enter the first city: ");
		city1 = input.nextLine();
		System.out.print("Enter the second city: ");
		city2 = input.nextLine();
		System.out.print("Enter the third city: ");
		city3 = input.nextLine();
		
		city1 = city1.substring(0, 1).toUpperCase() + city1.substring(1);
		city2 = city2.substring(0, 1).toUpperCase() + city2.substring(1);
		city3 = city3.substring(0, 1).toUpperCase() + city3.substring(1);
		
		if(city1.charAt(0) < city2.charAt(0) && city1.charAt(0) < city3.charAt(0)){
			if(city2.charAt(0) < city3.charAt(0)){
				System.out.println("The three cities in alphabetical order are " + city1 + " " + city2 + " " + city3);
			}
			else
				System.out.println("The three cities in alphabetical order are " + city1 + " " + city3 + " " + city2);
		}
		else if(city2.charAt(0) < city1.charAt(0) && city2.charAt(0) < city3.charAt(0)){
			if(city1.charAt(0) < city3.charAt(0)){
				System.out.println("The three cities in alphabetical order are " + city2 + " " + city1 + " " + city3);
			}
			else
				System.out.println("The three cities in alphabetical order are " + city2 + " " + city3 + " " + city1);
		}
		else{
			if(city1.charAt(0) < city2.charAt(0)){
				System.out.println("The three cities in alphabetical order are " + city3 + " " + city1 + " " + city2);
			}
			else
				System.out.println("The three cities in alphabetical order are " + city3 + " " + city2 + " " + city1);
		}
		
	}
	
}