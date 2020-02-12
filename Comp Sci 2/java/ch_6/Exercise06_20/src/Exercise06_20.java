import java.util.Scanner;

public class Exercise06_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String ch1 = input.nextLine();
		
		
		System.out.println(countLetters(ch1));
	}
	
	public static int countLetters(String s){
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
				count++;
			}
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
				count++;
			}
		}
	
		return count;
	}

}
