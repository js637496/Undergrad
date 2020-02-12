import java.util.Arrays;
import java.util.Scanner;

public class Exercise07_03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num;
		System.out.println("Enter the number of students: ");
		num = input.nextInt();
		double []scorelist = new double[num];
		String []namelist = new String[num];
		
		for (int i = 0; i < namelist.length; i++) {
			System.out.println("Enter name: ");
			namelist[i] = input.next();
			System.out.println("Enter score: ");
			scorelist[i] = input.nextDouble();
		}
		
		boolean sorted=true;
		  double temp;
		  String tem;

		  while (sorted){
		     sorted = false;
		     for (int i=0; i < scorelist.length-1; i++) 
		        if (scorelist[i] > scorelist[i+1]) {                      
		           temp = scorelist[i];
		           tem = namelist[i];
		           scorelist[i] = scorelist[i+1];
		           namelist[i] = namelist[i+1];
		           scorelist[i+1] = temp;
		           namelist[i+1] = tem;
		           sorted = true;
		        }          
		  }
		  
		  for (int i = namelist.length-1; i >= 0 ; i--) {
				
				
				System.out.println(namelist[i]);
				
			}
		
		
}
}


