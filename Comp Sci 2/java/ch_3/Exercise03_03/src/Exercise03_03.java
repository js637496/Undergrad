import java.util.Scanner;

public class Exercise03_03 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double a, b, c, d, e, f;
		System.out.print("Enter a, b, c, d, e, f: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		d = input.nextDouble();
		e = input.nextDouble();
		f = input.nextDouble();
		solveTwoAdditionEquationsXY(a,b,c,d,e,f);
		
	}
	
	public static void solveTwoAdditionEquationsXY(double xMultiplier1, double yMultiplier1, double xMultiplier2, double yMultiplier2, double quotient1,  double quotient2){
		
		double y = (xMultiplier1 * quotient2 - quotient1 * xMultiplier2)/(xMultiplier1 * yMultiplier2 - yMultiplier1 *xMultiplier2);
		double x = (quotient1 * yMultiplier2 - yMultiplier1 * quotient2)/(xMultiplier1 * yMultiplier2 - yMultiplier1 * xMultiplier2);
		if((xMultiplier1 * yMultiplier2 - yMultiplier1 * xMultiplier2) == 0)
			System.out.println("The equation has no solution");
		else
			System.out.println("x is " + x + " and y is " + y);
	}
}


