//Project Euler Problem 19
//By: Brandon Shearrer
//CS 2 Spring 2018

/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

public class P19
{
	public static void main(String[] args) 
	{
		System.out.println(P19.calculate());
	}
	
	public static String calculate() 
	{
		int count = 0;
		for (int y = 1901; y <= 2000; y++) 
		{
			for (int m = 1; m <= 12; m++) 
			{
				if (dayOfWeek(y, m, 1) == 0)  // Sunday
				{
					count++;
				}
			}
		}
		return Integer.toString(count);
	}
	
	// Return value: 0 = Sunday, 1 = Monday, ..., 6 = Saturday.
	private static int dayOfWeek(int year, int month, int day) 
	{
		if (year < 0 || year > 10000 || month < 1 || month > 12 || day < 1 || day > 31)
		{
			throw new IllegalArgumentException();
		}
		
		// Zeller's congruence algorithm
		int m = (month - 3 + 4800) % 4800;
		int y = (year + m / 12) % 400;
		m %= 12;
		return (y + y/4 - y/100 + (13 * m + 2) / 5 + day + 2) % 7;
	}
}