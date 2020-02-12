import java.util.Date;

public class Exercise09_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long mil = 1000;
		for(int i = 0; i < 8; i++){
			mil = mil * 10;
			Date test = new Date(mil);
			System.out.println(test.toString());
		}
		Date test = new Date();
		System.out.println(test.toString());
	}
	
}
