import java.util.Scanner;

public class Exercise03_01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double a, b, c;
		System.out.print("Enter a, b, c: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		calcQuadratic(a,b,c);
		
	}
	
	public static void calcQuadratic(double a, double b, double c){
		
		double quadratic1 = 0;
		double quadratic2 = 0;
		
		quadratic1 = (-b + Math.sqrt((Math.pow(b, 2) - (4 * a * c)))) / (2 * a);
		quadratic2 = (-b - Math.sqrt((Math.pow(b, 2) - (4 * a * c)))) / (2 * a);
		
		if ((Math.pow(b, 2) - (4 * a * c)) > 0){
			System.out.println("The equation has two roots " + quadratic1 + " and " + quadratic2);
		}
		else if((Math.pow(b, 2) - (4 * a * c)) == 0){
			System.out.println("The equation has one root " + quadratic1);
		}
		else{
			System.out.println("The equation has no real roots");
		}

	}

}
