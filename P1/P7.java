//Project Euler Problem 07
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10,001st prime number?
*/

/**
*@author 		Brandon Shearrer
*@version		1.0
*@date			2/25/2018
*/

public class P7
{
	public static int testnum;
	public static int increment;
	public static int num = 10001;

	public static void main(String[] args) 
	{
		System.out.println(nPrime(num));
 	}

 	public static int nPrime(int num) 
 	{
    	for(testnum = 2, increment = 0; increment < num; ++testnum) 
    	{
        	if (testPrime(testnum)) 
        	{
            	++increment;
        	}
    	}
	    // The testnum has been incremented once after the increment reached n
	    return testnum-1;
	}

	public static boolean testPrime(int num) 
 	{
    	for(int i = 2; i < num; ++i) 
    	{
        	if (num % i == 0) 
        	{
            	return false;
        	}
    	}
    	return true;
	}
}