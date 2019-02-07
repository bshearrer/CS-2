//Project Euler Problem 04
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

public class P4
{	
	public static void main(String[] args) 
	{
		System.out.println(P4.calculate());
	}
	public static boolean isPalindrome(String s) 
	{
		return s.equals(reverse(s));
	}
	public static boolean isPalindrome(int x) 
	{
		return isPalindrome(Integer.toString(x));
	}
	// Returns the reverse of the given string.
	public static String reverse(String s) 
	{
		return new StringBuilder(s).reverse().toString();
	}
	public static String calculate() 
	{
		int max = -1;
		for (int i = 100; i < 1000; i++) 
		{
			for (int j = 100; j < 1000; j++) 
			{
				int prod = i * j;
				if (isPalindrome(prod) && prod > max)
				{
					max = prod;
				}
			}
		}
		return Integer.toString(max);
	}	
}