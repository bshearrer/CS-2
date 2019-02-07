//Project Euler Problem 05
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

/**
*@author 		Brandon Shearrer
*@version		1.0
*@date			2/25/2018
*/

public class P5
{
	public static void main(String[] args) 
	{
		System.out.println(Calculations());
	}

	public static int Calculations()
	{
		int num = 1;
		boolean test = true;

		while(true)
		{
    		for (int i = 1; i <= 20; i++)
    		{
        		test = true;

        		if ( num % i != 0 )
        		{
	           	 	test = false;
	            	break;
	            }
	        }
    		if (test)
		   {
		        return num;
    		}
    		num++;
		}	
	}
}