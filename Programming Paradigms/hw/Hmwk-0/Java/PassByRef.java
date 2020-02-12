/**
    CSC345-80 Homework 0, PassByRef.java
    Purpose: Demonstrate passing integers by reference
    @author James Speers
    @Created  08/30/18 
*/
public class PassByRef 
{
	public static void main(String[] args) 
	{
		Int x = new Int(3);
		int y = square(x) + twice(x) + once(x);
		System.out.println(y);
	}
	
	/**
	    Sets an int n to n * n and returns new n
	    @param int to be squared.
	    @return the value of the int after it has been squared.
	*/
	static int square(Int x)
	{
		x.setValue(x.getValue() * x.getValue());
		return x.getValue();
	}

	/**
	    Sets an integer n to 2 * n and returns new n
	    @param integer to be doubled.
	    @return the value of the int after it has been doubled.
	*/
	static int twice(Int x)
	{
		x.setValue(x.getValue() * 2);
		return x.getValue();
	}

	/**
	    Returns the parameter
	    @param int to be returned.
	    @return the value of the int parameter.
	*/
	static int once(Int x)
	{
		return x.getValue();
	}
}
