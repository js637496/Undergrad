public class Exercise10_03 {
  public static void main(String[] args) {
    MyInteger n1 = new MyInteger(5);
    System.out.println("n1 is even? " + n1.isEven());
    System.out.println("n1 is prime? " + n1.isPrime());
    System.out.println("15 is prime? " + MyInteger.isPrime(15));

    char[] chars = {'3', '5', '3', '9'};
    System.out.println(MyInteger.parseInt(chars));

    String s = "3539";
    System.out.println(MyInteger.parseInt(s));
    
    MyInteger n2 = new MyInteger(24);
    System.out.println("n2 is odd? " + n2.isOdd());
    System.out.println("45 is odd? " + MyInteger.isOdd(45));
    System.out.println("n1 is equal to n2? " + n1.equals(n2));
    System.out.println("n1 is equal to 5? " + n1.equals(5));
  }
}

class MyInteger {
  int value;
  
  MyInteger(int sint){
	  
	  value = sint;
  }

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean isEven(){
		if(value%2==0)
			return true;
		return false;
		
	}
	public boolean isOdd(){
			if(value%2 == 1)
				return true;
			
			return false;
			
		}
	public boolean isPrime(){
		for(int i=2;i<value;i++) {
	        if(value%i==0)
	            return false;
	    }
	    return true;
		
	}
	
	static public boolean isEven(int value){
		if(value%2==0)
			return true;
		return false;
		
	}
	static public boolean isOdd(int value){
			if(value%2 == 1)
				return true;
			
			return false;
			
		}
	static public boolean isPrime(int value){
		for(int i=2;i<value;i++) {
	        if(value%i==0)
	            return false;
	    }
	    return true;
		
	}
	
	public boolean equals(int x){
		
		if(this.value == x)
			return true;
		return false;
	}
public boolean equals(MyInteger x){
		
		if(this.value == x.getValue())
			return true;
		return false;
	}

	static public int parseInt(char[] x){
	int y=0;
		String a = new String(x);
		y = Integer.parseInt(a);
		return y;
	}
	
	static public int parseInt(String a){
		int y;
		y = Integer.parseInt(a);
		return y;
	}
}