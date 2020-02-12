
/*$0.01–$5,000 8 percent

$5,000.01–$10,000 10 percent

$10,000.01 and above 12 percent

Note that this is a graduated rate. The rate for the first $5,000 is at 8%, the next 

$5000 is at 10%, and the rest is at 12%. If the sales amount is 25,000, the com-
mission is 5,000 * 8% + 5,000 * 10% + 15,000 * 12% = 2,700.
*/

public class Exercise06_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sales Amount\tCommission");
		System.out.println("_________________________________");
		for(int i = 10000; i <= 100000; i = i + 5000){
			System.out.println(i + "\t" + computeCommission(i));
		}
	}
	
	public static double computeCommission(double salesAmount){
		double comm = 0;
        if(salesAmount >= .01 && salesAmount <= 5000)
        	comm = comm + salesAmount * .08;
        if(salesAmount >= 5000.01 && salesAmount <= 10000){
        	comm = comm + 5000 * .08;
        	comm = comm + (salesAmount-5000) * .1;
        }
        if(salesAmount >= 10000.01){
        	comm = comm + 5000 * .08;
        	comm = comm + 5000 * .1;
        	comm = comm + (salesAmount-10000) * .12;
        }
        	
        
        
		
		return comm;
		
	}

}
