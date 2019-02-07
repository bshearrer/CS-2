//=============================
//Brandon Shearrer
//CS 2 - Assignment 1 
//Spring 2018
//=============================

import java.util.*;

public class Gregory 
{
	public static int input;
	public static double piGregSeries;
	public static double javaValue;

	public static void main(String[] args) 
	{
		try
		{
			input = Integer.parseInt(args[0]);
			System.out.println("Created By > Brandon Shearrer");
			System.out.println();
			
			if(args.length == 1) 
			{
				System.out.println("Pi according to Gregory seies: " + piGregSeries(input) + ".");
				System.out.println("This differs from Java's value by " + javaValue(piGregSeries(input)) + " percent.");
			} 
			else 
			{
				System.out.println("Usage: Java Gregory [number]");
			} 
		}
		catch (NumberFormatException ex) 
		{
			System.out.println("Too many numbers entered bro!");	
    	}
	}

	//Takes in the numbers from piGregSeries and user input, and finds the java difference
	public static double javaValue(double difference)
	{
		double javaDiff = (100 - (difference / Math.PI) * 100);

		return javaDiff;

	}

	//Takes in user input and converts it to the Gregory Series number.
	public static double piGregSeries(int n)
	{
		double total = 0;

		//Formula given: (Math.pow(-1, (i + 1))) / ((2 * i) -  1)
		for (int i = 1; i <= n; i++) 
		{
			double equation = (Math.pow(-1, (i + 1))) / ((2 * i) -  1);
			total += equation;
		}
		//Multiply by 4 to correct for the fact that this series converges to π/4, not, not π itself
		return total * 4;
	}
}
