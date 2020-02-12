/*
     A class to generate prime numbers
 */

public class PrimeGenerator
{ 
    private  int seed = 1;
    
    public  PrimeGenerator(){}
    

    // return the next prime after seed and rest seed
    public  int nextPrime()
    {
	seed = nextPrimeAfter(seed);
	return   seed;
    }


    // return the next prime after n
    private int nextPrimeAfter(int n)
    {
	if (n<1) return -1;
	if(n==1||n==2) return n+1;

	n = n+1+(n%2);  // so we can inc by 2s
	while(!isPrime(n))
	    n+=2;
	
	return n;
    }


    private boolean isPrime(int n)
    {
	if (n<=1) return false;
	if (n==2) return true;
	if (n%2==0) return false;
	for (int i=3; i<=(int)(Math.sqrt((double)n)); i+=2) // inc by 2s	    
	    if (n%i==0) return false;
	return true;	
    }
    
//==============================================================================
// Create some prime number generating objects and generate some primes

    public static void main(String[] args) 
    {
        PrimeGenerator pg1 = new PrimeGenerator();
        PrimeGenerator pg2 = new PrimeGenerator();
        
        for (int i=0; i<5; i++)                          // 2, 3, 5, 7, 11 
            System.out.println(pg1.nextPrime()); 
        
        System.out.println(); 
        
        for (int i=0; i<5; i++)                          // 2, 3, 5, 7, 11  
            System.out.println(pg2.nextPrime()); 
        
        System.out.println(); 
        
        for (int i=0; i<5; i++)                          // 13, 17, 19, 23, 29 
            System.out.println(pg1.nextPrime()); 
        
        System.out.println(); 
        
        System.out.println(pg2.nextPrime());             // 13
	
    }
}




//==============================================================================




