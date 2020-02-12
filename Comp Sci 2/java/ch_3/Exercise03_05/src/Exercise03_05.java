import java.util.Scanner;

public class Exercise03_05 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int startDay;
		int endDay;
		System.out.print("Enter today's day: ");
		startDay = input.nextInt();
		System.out.print("Enter the number of days elapsed since today: ");
		endDay = input.nextInt();
		
		String outputDay =  futureDay(startDay, endDay);
		System.out.println(outputDay);
		
	}
	
	public static String futureDay(int startDay, int endDay){
		String day1= "Error";
		String day2= "Error";
		int modVar;
		
		modVar = (endDay % 7) + startDay ;
		
		System.out.println(modVar);
		
		switch(startDay){
		case 0: day1 = "Sunday";
		break;
		case 1: day1 = "Monday";
		break;
		case 2: day1 = "Tuesday";
		break;
		case 3: day1 = "Wednesday";
		break;
		case 4: day1 = "Thursday";
		break;
		case 5: day1 = "Friday";
		break;
		case 6: day1 = "Saturday";
		break;
		}
		
		switch(modVar){
		case 0: day2 = "Sunday";
			break;
		case 1: day2 = "Monday";
		break;
		case 2: day2 = "Tuesday";
		break;
		case 3: day2 = "Wednesday";
		break;
		case 4: day2 = "Thursday";
		break;
		case 5: day2 = "Friday";
		break;
		case 6: day2 = "Saturday";
		break;
		}
		
		
		
		return ("Today is " + day1 + " and the future day is " + day2);
	}
}

