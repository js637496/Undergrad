import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int pole1[], pole2[], pole3[];
		int numPlates;
		//int moves = 0;
		//System.out.println("How many plates to start? ");
		numPlates = 3;
		pole1 = new int[numPlates];
		pole2 = new int[numPlates];
		pole3 = new int[numPlates];
		
		for(int i = 0; i < 3; i++){
			pole1[i] = numPlates;
			pole2[i] = -1;
			pole3[i] = -1;
			numPlates--;
		}
		pole3[0] = pole1[2];
		pole1[2] = -1;
		pole2[0] = pole1[1];
		pole1[1] = -1;
		pole2[1] = pole3[0];
		pole3[0] = -1;
		pole3[0] = pole1[0];
		pole1[0] = -1;
		pole1[0] = pole2[1];
		pole2[1] = -1;
		pole3[1] = pole2[0];
		pole2[0] = -1;
		pole3[2] = pole1[0];
		pole1[0] = -1;
		
		System.out.println(pole3[2] + " \n" + pole3[1] + " \n" + pole3[0] + " ");
		
		
		
		
		
	}

}
