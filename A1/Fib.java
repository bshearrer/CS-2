//=============================
//Brandon Shearrer
//CS 2 - Assignment 1 
//Spring 2018
//=============================

public class Fib
{
	public static int input;

	public static void main(String[] args)
	{
		System.out.println("Created By > Brandon Shearrer");
		System.out.println();
		
		if (args.length == 1) 
		{
			input = Integer.parseInt(args[0]);
		}	
		else
		{
			System.out.println("Usage: Java Fib [number]");
			System.exit(1);
		}

		System.out.println(fib(input));	
	}

	public static int fib(int x)
	{
		if (x == 0) 
		{
			return 0;	
		}
		else if (x == 1) 
		{
			return 1;	
		}
		else
		{
			return fib(x-1) + fib(x-2);
		}
	}
}
