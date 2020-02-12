/**
    CSC345-80 Homework 0, PassByRef.cpp
    Purpose: Demonstrate passing integers by reference
    @author James Speers
    @Created  08/30/18 
*/
#include <iostream>
using namespace std;

int square(int&);
int twice(int&);
int once(int&);

int main() 
{
	int x = 3;
	int y =  square(x) + twice(x) + once(x);
	cout << y << endl;
	return 0;
}

/**
    Sets an int n to n * n and returns new n
    @param int to be squared.
    @return the value of the int after it has been squared.
*/
int square(int &x)
{
	x = x * x;
	return x;
}

/**
    Sets an integer n to 2 * n and returns new n
    @param integer to be doubled.
    @return the value of the int after it has been doubled.
*/
int twice(int &x)
{
	x = 2 * x;
	return x;
}

/**
    Returns the parameter
    @param int to be returned.
    @return the value of the int parameter.
*/
int once(int &x)
{
	return x;
}












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































%%% Represents file annotation not included in the initial run
%%% First run result C++
45
%%% Second run result C++
45




%%% Represents file annotation not included in the initial run
%%% First run result Java
45
%%% Second run result Java
45
