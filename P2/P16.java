//Project Euler Problem 16
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/

import java.math.*;

public class P16
{
	public static int sum = 0;

	public static void main(String[] args)
	{
		BigInteger n = BigInteger.valueOf(2);
		n = n.pow(1000);
		System.out.println(mathCalculations(n.toString()));
	}

	public static int mathCalculations(String s)
	{		
		for (int i = 0; i < s.length(); i++)
		{
			Character c = new Character(s.charAt(i));
			String z = c.toString();
			int j = Integer.parseInt(z);
			sum += j;
		}	
		return sum;
	}
}