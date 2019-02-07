//Project Euler Problem 14
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/
import java.math.BigInteger;

public class P14
{
	private static final int LIMIT = pow(10, 6);
	private static final BigInteger CACHE_SIZE = BigInteger.valueOf(LIMIT);
	private static int[] collatzChainLength = new int[CACHE_SIZE.intValue()];

	public static void main(String[] args) 
	{
		System.out.println(P14.calculate());
	}
	
	public static String calculate() 
	{
		int maxArg = -1;
		int maxChain = 0;
		for (int i = 1; i < LIMIT; i++) 
		{
			int chainLen = collatzChainLength(BigInteger.valueOf(i));
			if (chainLen > maxChain) 
			{
				maxArg = i;
				maxChain = chainLen;
			}
		}
		return Integer.toString(maxArg);
	}
	// Returns x to the power of y, throwing an exception if the result overflows an int.
	public static int pow(int x, int y) {
		if (x < 0)
			throw new IllegalArgumentException("Negative base not supported");
		if (y < 0)
			throw new IllegalArgumentException("Negative exponent");
		int z = 1;
		for (int i = 0; i < y; i++) {
			if (Integer.MAX_VALUE / z < x)
				throw new ArithmeticException("Overflow");
			z *= x;
		}
		return z;
	}
	
	// Returns the Collatz chain length of the given integer with automatic caching.
	private static int collatzChainLength(BigInteger n) 
	{
		if (n.signum() < 0)
		{
			throw new IllegalArgumentException();
		}
		
		if (n.compareTo(CACHE_SIZE) >= 0)  // Caching not available
		{
			return collatzChainLengthDirect(n);
		}
		
		int index = n.intValue();  // Index in the cache
		if (collatzChainLength[index] == 0)
		{
			collatzChainLength[index] = collatzChainLengthDirect(n);
		}
		return collatzChainLength[index];
	}

	private static int collatzChainLengthDirect(BigInteger n) 
	{
		if (n.equals(BigInteger.ONE))  // Base case
		{
			return 1;
		}
		else if (!n.testBit(0))  // If n is even
		{
			return collatzChainLength(n.shiftRight(1)) + 1;
		}
		else  // Else n is odd
		{
			return collatzChainLength(n.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE)) + 1;
		}
	}
}