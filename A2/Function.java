//=============================
//Brandon Shearrer
//CS 2 - Assignment 2
//Spring 2018
//=============================

/**
* This class implements sublcasses with different ways to find the root of functions
* between two given numbers and an a certain amount of error (in this case epsilon).
*
*@author	Brandon Shearrer
*@since		2/13/2018
*@version 	1.1
*/

public abstract class Function
{
	/**
	* Abstract method provides implementations for what we will use when
	* using findRoot()
	*
	*@param x The value that we will evaluate for whatever function is implemented
	*@return double This will return the value of the function implemented at its specified value
	*/
	public abstract double evaluate(double x);

	/**
	* epsilon is the amount of error that is acceptable in our answers.
	*/
	public static double epsilon = 0.00000001;

	/**
	* This method provides the math behind any method passed through to find a 
	* specified root of any given sin, cos, or polynomial
	*
	*@param a The first boundary of area
	*@param b The second boundary of area
	*@param epsilon The amount of acceptable error
	*@return Specified root after being passed in.
	*/
	public double findRoot(double a, double b, double epsilon)
	{
		//use Math.sin() as the function to be evaluated
		double x = 0.5 * (a + b);
		if (Math.abs(a - x) < epsilon) 
		{
			return x;
		}
		else if (evaluate(a) > 0 && evaluate(x) > 0 || evaluate(a) < 0 && evaluate(x) < 0) 
		{
			return findRoot(x, b, epsilon);
		}
		else
		{
			return findRoot(a, x, epsilon);
		}
	}

	/**
	* This is the main method which makes use of the findRoot method
	*@param args Unused
	*@return Nothing
	*@exception IOException On input error
	*@see IOException
	*/
	public static void main(String[] args)
	{
		SinFunc sine = new SinFunc();
		CosFunc cosine = new CosFunc();
		int[] int1 = {-3, 0, 1};
		int[] int2 = {-2, -1, 1};
		PolyFunc polynomial1 = new PolyFunc(int1);
		PolyFunc polynomial2 = new PolyFunc(int2);
		
		System.out.println("Root of Sine between 3 and 4 = " + sine.findRoot(3, 4, epsilon));
		System.out.println("Root of Cos between 1 and 3  = " + cosine.findRoot(1, 3, epsilon));
		System.out.println("Root of x^2-3   = " + polynomial1.findRoot(0, 250, epsilon));
		System.out.println("Root of x^2-x-2 = " + polynomial2.findRoot(0, 250, epsilon));
	}
}