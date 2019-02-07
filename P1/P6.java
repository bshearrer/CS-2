//Project Euler Problem 06
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

/**
*@author 		Brandon Shearrer
*@version		1.0
*@date			2/25/2018
*/
public class P6
{
	public static void main(String[] args) 
	{
		System.out.println(Calculations());
	}
	
	public static int Calculations() 
	{
		int sum1 = 0;
		int sum2 = 0;
		int difference;

		for (int i = 1; i <= 100; i++) 
		{
			sum1 = sum1 + i;
			sum2 = sum2 + (i * i);

		}
		difference = sum1 * sum1 - sum2;
		return difference;
	}
}