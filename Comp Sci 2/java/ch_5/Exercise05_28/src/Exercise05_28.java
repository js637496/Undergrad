import java.util.Scanner;

public class Exercise05_28 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int y, d;
		String day1 = "Error";
		String month = "Error";
		System.out.print("Enter year: ");
		y = input.nextInt();
		//System.out.print("Enter month: ");
		//m = input.nextInt();
		//System.out.print("Enter day of the month: ");
		d = 1;
		int m1, y1;
		
		for(int m = 1; m<=12; m++){
			int h;
			m1=m;
			y1=y;
			if(m==1){
				m1 = 13;
				y1 = y1 - 1;
			}
			if(m==2){
				m1 = 14;
				y1 = y1 - 1;
			}
			
			int k = y%100;
			int j = (int)(y/100);
			
			//System.out.println(j);
			
			
			
			h = (d + (int)((26 * (m1+ 1)) / 10.0) +  y1 + (int)(y1 / 4.0) +  6 * (int)(y1 / 100.0) +(int)(y1 / 400.0))% 7;
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
			switch(m){
			case 1: month = "January";
			break;
			case 2: month = "February";
			break;
			case 3: month = "March";
			break;
			case 4: month = "Arpil";
			break;
			case 5: month = "May";
			break;
			case 6: month = "June";
			break;
			case 7: month = "July";
			break;
			case 8: month = "August";
			break;
			case 9: month = "September";
			break;
			case 10: month = "October";
			break;
			case 11: month = "November";
			break;
			case 12: month = "December";
			break;
			}
			
		
			System.out.println(month + " 1, " + y + " is " + day1);
		}
		
		//String outputDay =  futureDay(year, month, day);
		
		
	}
	

}
