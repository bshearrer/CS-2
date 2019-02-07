//=============================
//Brandon Shearrer
//CS 2 - Assignment 2 
//Spring 2018
//=============================

public class Ramanujan
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
				System.out.println("Pi according to Ramanujan seies: " + piRamanujan(input) + ".");
				System.out.println("This differs from Java's value by " + javaValue(piRamanujan(input)) + " percent.");
			} 
			else 
			{
				System.out.println("Usage: Java Ramanujan [number]");
			} 
		}
		catch (NumberFormatException ex) 
		{
			System.out.println("Too many numbers entered bro!");	
    	}
	}

	//Takes in the numbers from piRamanujan and user input, and finds the java difference
	public static double javaValue(double difference)
	{
		double javaDiff = (100 - (difference / Math.PI) * 100);

		return javaDiff;

	}

	//Takes in user input and converts it to the Ramanujan number.
	public static double piRamanujan(int n)
	{
		double rightEquation = 0;
		double leftEquation = ((2*Math.sqrt(2)) / 9801);;
		double result = 0;

		for (int i = 0; i < n; i++) 
		{
			rightEquation += ((Factorial.calculate(4 * i)) * (1103 + (26390 * i))) / (Math.pow(Factorial.calculate(i), 4) * Math.pow(396, (4 * i)));	
		}

		rightEquation *= leftEquation;
		result = 1 / rightEquation;

		return result;
	}
}