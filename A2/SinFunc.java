//=============================
//Brandon Shearrer
//CS 2 - Assignment 2
//Spring 2018
//=============================

/**
* This class extends the Function class to implement evaluate
* and return the result of the sine parameters
*
*@author	Brandon Shearrer
*@version 	1.1
*@since		2/13/2018
*/

public class SinFunc extends Function
{
	/**
	*This method is to evaluate the sine function when the SinFunc class is called
	*@param x The variable of the number that will be evaluated
	*@return math.sin(x) The result of sin(x)
	*/
	public double evaluate(double x)
	{
		return Math.sin(x);
	}
}