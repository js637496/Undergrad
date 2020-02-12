import java.util.Scanner;

public class Exercise03_21 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int year, month, day;
		System.out.print("Enter year: ");
		year = input.nextInt();
		System.out.print("Enter month: ");
		month = input.nextInt();
		System.out.print("Enter day of the month: ");
		day = input.nextInt();
		
		String outputDay =  futureDay(year, month, day);
		System.out.println(outputDay);
		
	}
	
	public static String futureDay(int y, int m, int q){
		String day1= "Error";
		int h;
		
		if(m==1){
			m = 13;
			y = y - 1;
		}
		if(m==2){
			m = 14;
			y = y - 1;
		}
		
		int k = y%100;
		int j = (int)(y/100);
		
		//System.out.println(j);
		
		
		
		h = (q + (int)((26 * (m + 1)) / 10.0) +  y + (int)(y / 4.0) +  6 * (int)(y / 100.0) +(int)(y / 400.0))% 7;
		
		
		switch(h){
		case 0: day1 = "Saturday";
		break;
		case 1: day1 = "Sunday";
		break;
		case 2: day1 = "Monday";
		break;
		case 3: day1 = "Tuesday";
		break;
		case 4: day1 = "Wednesday";
		break;
		case 5: day1 = "Thursday";
		break;
		case 6: day1 = "Friday";
		break;
		}		
		
		return (day1);
	}
}

