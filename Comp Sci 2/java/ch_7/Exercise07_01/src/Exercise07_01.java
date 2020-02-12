import java.util.Scanner;

public class Exercise07_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		int numStudents = input.nextInt();
		int []stuGrades = new int[numStudents];
		System.out.println("Enter " + numStudents + " scores: ");
		for (int i = 0; i < stuGrades.length; i++) {
			stuGrades[i] = input.nextInt();
		}
		int best = 0;
		for (int i = 0; i < stuGrades.length; i++) {
			if(stuGrades[i] > best)
				best = stuGrades[i];
		}
		for (int i = 0; i < stuGrades.length; i++) {
			if(stuGrades[i] >= best - 10)
				System.out.println("Student " + i + "score is " + stuGrades[i] + "and grade is A");
			else if(stuGrades[i] >= best - 20)
				System.out.println("Student " + i + "score is " + stuGrades[i] + "and grade is B");
			else if(stuGrades[i] >= best - 30)
				System.out.println("Student " + i + "score is " + stuGrades[i] + "and grade is C");
			else if(stuGrades[i] >= best - 40)
				System.out.println("Student " + i + "score is " + stuGrades[i] + "and grade is D");
			else
				System.out.println("Student " + i + "score is " + stuGrades[i] + "and grade is F");
		}
		
	}

}
