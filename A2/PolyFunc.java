//=============================
//Brandon Shearrer
//CS 2 - Assignment 2
//Spring 2018
//=============================

/**
* This class uses the evaluate() methods to return the results of
* any given polynomial(Ex: {1,-2,3} = 3x^2-2x+1).
*
*@author	Brandon Shearrer
*@version	1.1
*@since		2/13/2018
*/

public class PolyFunc extends Function
{
	/**
	* Initial int array to store the values of x^number, or the coefficients of x.
	*/
	public int[] xnumber;

	/**
	*Constructor for an array of coefficients
	*
	*@param coefficients array The array of coefficients for x
	*/
	public PolyFunc(int[] coefficients)
	{
		this.xnumber = coefficients;
	}

	/**
	*Constructor for the length of each polynomial
	*
	*@return this.xnumber.length The length of the given array
	*/
	public int polyLength()
	{
		return this.xnumber.length;
	}

	/**
	*Constructor to return the power of the highest non-zero term
	*
	*@return this.xnumber.length-1 Returns the highest degree polynomial
	*/
	public int degree()
	{
		return this.xnumber.length-1;
	}

	/**
	*Constructor to override the Objects class's toString method
	**returns a String representation of the polynomial using x as the variable
	*arranged in decreasing order of exponent printing nothing with a zero coefficient
	*Ex: [4,0,-8,0,3,2] returns: 2x^5+3x^4-8x^2+4
	*
	*@return stringbuild.toString() The StringBuilder will use its functionality to return the polynomial as a string
	*/
	public String toString()
	{
		StringBuilder stringbuild = new StringBuilder();
		//usestringbuild.append to add to the string

		for(int i = this.polyLength() - 1; i >= 0; i--)
		{


			if(i == this.polyLength() - 1)
			{
				stringbuild.append(this.xnumber[i] + "x^" + i);
			} 
			else if(i == 0)
			{
				if(this.xnumber[i] > 0) 
				{
					stringbuild.append("+" + this.xnumber[i]);
				} 
				else 
				{
					stringbuild.append(this.xnumber[i]);
				}
			} 
			else if(i == 1)
			{

				if(this.xnumber[i] == 0)
				{
					continue;
				} 
				else if(this.xnumber[i] > 0)
				{
					stringbuild.append("+" + this.xnumber[i] + "x");
				} 
				else 
				{
					stringbuild.append(this.xnumber[i] + "x");
				}
			} 
			else if (this.xnumber[i] == 0) 
			{
				continue;
			} 
			else if(this.xnumber[i] == 1)
			{
				stringbuild.append("+x^" + i);
			}
			else 
			{
				if(this.xnumber[i] > 0)
				{
					stringbuild.append("+" + this.xnumber[i] + "x^" + i);
				} 
				else 
				{
					stringbuild.append(this.xnumber[i] + "x^" + i);
				}
			}
		}
		return stringbuild.toString();
	}

	/**
	*Constructor to add two polynomails
	*Ex:(2x^5 + 3x^4 - 8x^2 + 4) + (x^3 + 4x^2 - 2x) = (2x^5 + 3x^4 + x^3 - 4x^2 - 2x + 4).
	*
	*@param a A polynomial used to be added from the object
	*@return myPolyFunc A new polynomial that has resulted in adding the two polynomials together
	*/
	public Poly add(Poly a)
	{
		if(this.polyLength() < a.polyLength())
		{
			int[] polynomial = new int[a.polyLength()];

			for(int i = 0; i < this.polyLength()-1; i++)
			{
				polynomial[i] = this.xnumber[i] + a.xnumber[i];
			}
			for(int i = this.polyLength() - 1; i < a.polyLength(); i++)
			{
				polynomial[i] = a.xnumber[i];
			}
			Poly myPoly = new Poly(polynomial);
			return myPoly;
			
		} 
		else if(this.polyLength() > a.polyLength())
		{
			int[] polynomial = new int[this.polyLength()];
			for(int i = 0; i < a.polyLength() - 1; i++)
			{
				polynomial[i] = this.xnumber[i] + a.xnumber[i];
			}
			for(int i = a.polyLength() - 1; i < this.polyLength(); i++)
			{
				polynomial[i] = this.xnumber[i];
			}
			Poly myPoly = new Poly(polynomial);
			return myPoly;
		
		} 
		else 
		{
			int[] polynomial = new int[a.polyLength()];
			for(int i = 0; i < a.polyLength() - 1; i++)
			{
				polynomial[i] = this.xnumber[i] + a.xnumber[i];
			}
			Poly myPoly = new Poly(polynomial);
			return myPoly;
		
		}
	}

	/**
	*Constructor to return the value of the function at the point x
	*Ex: If Poly object represents 2x^5+3x^4-8x^2+4 and evaluate(2.0) is called
	*   the method should calculate 2(2)^5+3(2)^4-8(2)^2+4 and return 84
	*
	*@param x The variable that will be passed in to evaluate the polynomial
	*@return total The total value of the polynomial when given a specific number
	*/
	public double evaluate(double x)
	{
		double total = 0;
		int i = 0;
		while(true)
		{
			if (i<this.polyLength()) 
			{
				total+= xnumber[i] * Math.pow(x, i);
				i++;
			}
			else
			{
				break;
			}
		}
		return total;
	}
}
