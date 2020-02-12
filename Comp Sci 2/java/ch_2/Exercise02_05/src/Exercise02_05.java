//Jim Speers
//1/31/2016
//CIS 164 Section 450
import java.util.Scanner;
public class Exercise02_05 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double gratuity, subtotal;
		System.out.print("Enter the subtotal and gratuity rate: ");
		subtotal = input.nextDouble();
		gratuity = input.nextDouble();
		System.out.println("The gratuity is $" + calcTip(gratuity, subtotal) + "and the total is $" + calcTotal(gratuity, subtotal));
		
	}
	
	public static double calcTip(double tip, double subTotal){
		return ((tip/100) * subTotal);
	}
	public static double calcTotal(double tip, double subTotal){
		return ((tip/100) * subTotal + subTotal);
	}
	
}