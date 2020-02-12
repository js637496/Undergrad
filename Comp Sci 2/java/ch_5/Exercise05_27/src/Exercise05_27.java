import java.util.Scanner;
import java.util.*;

public class Exercise05_27 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int count = 0;
		for(int i = 101; i <= 2100; i++){
			
			if(i%4==0){
				count++;
				System.out.print(i + " ");
				if(count%10==0)
					System.out.print("\n");
			}
			
		}
		
	}
}
