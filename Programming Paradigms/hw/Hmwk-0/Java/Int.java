/**
    CSC345-80 Homework 0, Int.java
    Purpose: Mutable integer class
    @author James Speers
    @Created  08/30/18 
*/
public class Int
{
	int value;

	Int(int n)
	{
		this.value = n;
	}

	/**
	    Returns value of Int.
	    @return value of Int.
	*/
	public int getValue()
	{
		return value; 
	}

	/**
	    Sets value of Int.
	    @return Sets of Int.
	*/
	public void setValue(int x)
	{
		this.value = x;
	}
}
