//Project Euler Problem 03
//By: Brandon Shearrer
//CS 2 Spring 2018


/*
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
*/

/**
*@author 		Brandon Shearrer
*@version		1.0
*@date			2/25/2018
*/

public class P3
{
	public static long num = 600851475143l;

	public static long FactorSolver(long x) 
	{
		//Start by 2 to remove divide by zero
    	for (x = 2; x <= num; x++) 
    	{
        	if (num % x == 0) 
        	{
            	num /= x;
           		x--;
        	}
        }
   	 	return x;
    }
	
	public static void main(String[] args) 
	{
		System.out.println(FactorSolver(num));
	}
}