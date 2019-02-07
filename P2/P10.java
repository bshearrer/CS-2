//Project Euler Problem 10
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

public class P10
{
	/* returns true if parameter n is a prime number, false if not */
    public static boolean isPrime(long n) 
    {
        if (n < 2) 
		{
        	return false;
        }
        else if (n == 2) 
        {
        	return true;
        }
        for (int i = 2; i < Math.pow(n, 0.5) + 1; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static long primeSum(long n)
    {
    	long sum = 0;
        for (int i = 0; i < 2000000; i++)
        {
            if (isPrime(i))
            {
                sum += i;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) 
    {
        System.out.println(primeSum(2000000));
    }
}