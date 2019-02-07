//Project Euler Problem 15
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
*/
import java.math.BigInteger;

public class P15
{
	public static void main(String[] args) 
	{
		System.out.println(P15.calculate());
	}
	
	public static String calculate() 
	{
		return binomial(40, 20).toString();
	}

	public static BigInteger binomial(int n, int k) {
		if (k < 0 || k > n)
		{
			throw new IllegalArgumentException();
		}
		BigInteger product = BigInteger.ONE;
		for (int i = 0; i < k; i++)
		{
			product = product.multiply(BigInteger.valueOf(n - i));
		}
		return product.divide(factorial(k));
	}
	
	// Returns n!.
	public static BigInteger factorial(int n) 
	{
		if (n < 0)
		{
			throw new IllegalArgumentException("Factorial of negative number");
		}
		BigInteger prod = BigInteger.ONE;
		for (int i = 2; i <= n; i++)
		{
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		return prod;
	}
}