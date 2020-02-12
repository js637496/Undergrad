
public class testAlg {
	public static void main(String[] args) {
		int n = 10;
		System.out.print("n = " + n);
		System.out.print("   A time = " + A(n));
		System.out.print("   B time = " + B(n));
		System.out.print("   C time = " + C(n));
		
		System.out.println();
		n = 1000;
		System.out.print("n = " + n);
		System.out.print("   A time = " + A(n));
		System.out.print("   B time = " + B(n));
		System.out.print("   C time = " + C(n));
		
		
		System.out.println();
		n = 100000;
		System.out.print("n = " + n);
		System.out.print("   A time = " + A(n));
		System.out.print("   B time = " + B(n));
		System.out.print("   C time = " + C(n));
		
		
	}
	public static long A(int n){
		long startTime = System.nanoTime();
		int sum = 0;
		for(int i = 1; i <= n; i++)
			sum=sum+i;
		
	
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		return  duration;
	}
	public static long B(int n){
		long startTime = System.nanoTime();
		int sum = 0;
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= i; j++)
				sum=sum+i;
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		return  duration;
	}
	public static long C(int n){
		long startTime = System.nanoTime();
		int sum = n*(n+1)/2;
	
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		return  duration;
		//return sum;
	}

}
