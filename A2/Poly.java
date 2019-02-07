//=============================
//Brandon Shearrer
//CS 2 - Assignment 2
//Spring 2018
//=============================

public class Poly
{
	public int[] xnumber;

	//Constructor for an array of coefficients
	public Poly(int[] coefficients)
	{
		this.xnumber = coefficients;
	}

	//Constructor for the length of each polynomial
	public int polyLength()
	{
		return this.xnumber.length;
	}

	//Constructor to return the power of the highest non-zero term
	public int degree()
	{
		return this.xnumber.length-1;
	}

	//Constructor to override the Objects class's toString method
	//returns a String representation of the polynomial using x as the variable
	//arranged in decreasing order of exponent printing nothing with a zero coefficient
	//Ex: [4,0,-8,0,3,2] returns: 2x^5+3x^4-8x^2+4
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

	//Constructor to add two polynomails
	//Ex:(2x^5 + 3x^4 - 8x^2 + 4) + (x^3 + 4x^2 - 2x) = (2x^5 + 3x^4 + x^3 - 4x^2 - 2x + 4).
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

	//Constructor to return the value of the function at the point x
	//Ex: If Poly object represents 2x^5+3x^4-8x^2+4 and evaluate(2.0) is called
	//    the method should calculate 2(2)^5+3(2)^4-8(2)^2+4 and return 84
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

	//Main method containing series of tests which exercise each of these methods and report their success or failure.
	public static void main(String[] args)
	{
		int[] testArray1 = {2, 0, 0, 4, -5, 8};
		int[] testArray2 = {4, 9, 12, -2};
		int[] testArray4 = {4, -2, -4, 1, 3, 2};
		Poly poly1 = new Poly(testArray1);
		Poly poly2 = new Poly(testArray2);
		Poly poly3 = poly1.add(poly2);
		Poly poly4 = new Poly(testArray4);

		System.out.println("Correct Value: 8x^5-5x^4+4x^3+2 \n Poly 1 Value: " + poly1.toString());
		System.out.println("\nCorrect Value: -2x^3+12x^2+9x+4 \n Poly 2 Value: " + poly2.toString());
		System.out.println("\n     Poly 1      +      Poly 2      =         Poly 3\n" + poly1.toString() + " + " + poly2.toString() + " = " + poly3.toString());
		System.out.println("\nf(x) = " + poly3.toString() + "\nf(2) = 8(2)^5-5(2)^4+4(2)^3+12(2)^2+9(2)+6 \n     = "+ poly3.evaluate(2.0));

		if (poly3.evaluate(2.0) == 280)  
		{
			System.out.println("All Tests Passed!");
		}
		else
		{
			System.out.println("Tests Failed.");
		}
	}
}