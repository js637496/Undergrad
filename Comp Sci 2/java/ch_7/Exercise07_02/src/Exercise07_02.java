import java.util.Scanner;

public class Exercise07_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		int []stuGrades = new int[10];
		
		for (int i = 0; i < stuGrades.length; i++) {
			System.out.println("Read a number: ");
			stuGrades[i] = input.nextInt();
		}
		
		for(int i = stuGrades.length-1; i >=0; i--)
			System.out.print(stuGrades[i] + " ");
		
	}


}
