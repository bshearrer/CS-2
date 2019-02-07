//=============================
//Brandon Shearrer
//CS 2 - Assignment 1 
//Spring 2018
//=============================

import java.util.*;

public class Average
{
	public static void main(String[] args)
	{
		System.out.println("Created By > Brandon Shearrer");
		System.out.println();
		double avg = 0.0;
		int input = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a series of numbers. Enter a negative number to quit.");
		System.out.println("------------------------------------------------------------------");
		
		while(scan.hasNextDouble())
		{
			double num = scan.nextDouble();

			if (num > 0.0) 
			{
				avg += num; 
				input ++;
			}

			else
			{
				break;
			}
		}

		System.out.println("You entered " + input + " numbers which averages " + (avg)/(input));
	}
}