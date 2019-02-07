//Project Euler Problem 10
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
*/
import java.math.*;

public class P20
{
	public static String temp = factorial(100).toString();
	public static int sum = 0;

	public static void main(String[] args) 
	{
		System.out.println(calculate());
	}

	public static BigInteger factorial(int num) 
	{
		BigInteger factorial = BigInteger.ONE;
		for (int i = 2; i <= num; i++)
		{
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	public static String calculate() 
	{
		for (int i = 0; i < temp.length(); i++)
		{
			sum += temp.charAt(i) - '0';
		}
		return Integer.toString(sum);
	}
}