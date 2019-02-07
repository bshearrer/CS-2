//Project Euler Problem 09
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

public class P9
{
	public static double num = 1000;
	public static double count = 0;

	public static void main(String[] args)
	{
		System.out.println(Math((int)num));
	}

	public static int Math(int result)
	{
		for (int i = 2; i <= (num/3 - 1); i++) 
		{
			count = (num -(500*num / (num-i)));	

			if (count == (int)count)
			{
				result = (int)(i*count*(num-i-count));
				break;
			}
		}
		return result;
	}
}