
public class Exercise06_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 2000; i <= 2020; i++)
			System.out.println(i + " " + numberOfDaysInAYear(i));
	}
	public static int numberOfDaysInAYear(int year){
		if ((year % 4 == 0))
			return 366;
		else
			return 365;
			
	}

}
