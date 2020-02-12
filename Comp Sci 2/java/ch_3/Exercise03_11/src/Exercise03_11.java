import java.util.Scanner;

public class Exercise03_11 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int month;
		int year;
		int days = 0;
		String monthString = "Error";
		System.out.print("Enter a month and year: ");
		month = input.nextInt();
		year = input.nextInt();
		
		if(leapYear(year) && month == 2){
			System.out.println("February " + year + " had 29 days");
		}
		else{
			switch (month){
			case 1: 
				monthString = "January";
				days = 31;
				break;
			case 2: 
				monthString = "February";
				days = 28;
				break;
			case 3: 
				monthString = "March";
				days = 31;
				break;
			case 4: 
				monthString = "April";
				days = 30;
				break;
			case 5: 
				monthString = "May";
				days = 31;
				break;
			case 6: 
				monthString = "June";
				days = 30;
				break;
			case 7: 
				monthString = "July";
				days = 31;
				break;
			case 8: 
				monthString = "August";
				days = 31;
				break;
			case 9: 
				monthString = "September";
				days = 30;
				break;
			case 10: 
				monthString = "October";
				days = 31;
				break;
			case 11: 
				monthString = "November";
				days = 30;
				break;
			case 12: 
				monthString = "December";
				days = 31;
				break;
			
			}
			System.out.println(monthString + " " + year + " had " + days + " days");
		}
		
		
		System.out.println();
		
	}
	
	public static boolean leapYear(int year){
		 if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
			return true;
		}
		else
			return false;
	}
}

