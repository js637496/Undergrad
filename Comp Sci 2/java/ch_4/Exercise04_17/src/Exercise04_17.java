import java.util.Scanner;

public class Exercise04_17 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String month;
		int year;
		int days = 0;
		String monthString = "Error";
		System.out.print("Enter a year: ");
		year = input.nextInt();
		System.out.print("Enter a month: ");
		month = input.next();
		
		String output = month.substring(0, 1).toUpperCase() + month.substring(1);
		
		if(leapYear(year) && month == "Feb"){
			System.out.println("Feb " + year + " has 29 days");
		}
		else{
			switch (month){
			case "Jan": 
				monthString = "January";
				days = 31;
				break;
			case "Feb": 
				monthString = "February";
				days = 28;
				break;
			case "Mar": 
				monthString = "March";
				days = 31;
				break;
			case "Apr": 
				monthString = "April";
				days = 30;
				break;
			case "May": 
				monthString = "May";
				days = 31;
				break;
			case "Jun": 
				monthString = "June";
				days = 30;
				break;
			case "Jul": 
				monthString = "July";
				days = 31;
				break;
			case "Aug": 
				monthString = "August";
				days = 31;
				break;
			case "Sep": 
				monthString = "September";
				days = 30;
				break;
			case "Oct": 
				monthString = "October";
				days = 31;
				break;
			case "Nov": 
				monthString = "November";
				days = 30;
				break;
			case "Dec": 
				monthString = "December";
				days = 31;
				break;
			default: monthString = "Invalid month";
            		break;
			
			}
			if(monthString == "Invalid month")
				System.out.println(month + " is an invalid input");
			else
				System.out.println(output + " " + year + " has " + days + " days");
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
