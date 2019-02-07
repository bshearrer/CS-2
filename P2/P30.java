//Project Euler Problem 09
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/

public final class P30
{
	
	public static void main(String[] args) 
	{
		System.out.println(Calculate());
	}
	
	
	public static String Calculate() 
	{
		// If a number has at least n >= 7 digits, then if every digit is 9 -> n * 9^5 is still less than the number (which is at least 10^n).
		int sum = 0;
		for (int i = 2; i < 1000000; i++) 
		{
			if (i == fifthPowerSum(i))
				sum += i;
		}
		return Integer.toString(sum);
	}
	
	
	public static int fifthPowerSum(int num) 
	{
		int sum = 0;
		while (num != 0) 
		{
			int exp = num % 10;
			sum += exp * exp * exp * exp * exp;
			num /= 10;
		}
		return sum;
	}
}