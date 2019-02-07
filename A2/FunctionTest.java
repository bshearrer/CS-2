//=============================
//Brandon Shearrer
//CS 2 - Assignment 2
//Spring 2018
//=============================

public class FunctionTest extends Function
{
	public static double epsilon = 0.00000001;

	public double findRoot(double a, double b,  double epsilon) {
		double x = (a + b) / 2;
		if (Math.abs(a - x) < epsilon) {
			return x;
		} else if (evaluate(a) > 0 && evaluate(x) > 0 || evaluate(a) < 0 && evaluate(x) < 0){
			return findRoot(x, b, epsilon);
		} else {
			return findRoot(a, x, epsilon);
		}
	}

	public double evaluate(double x)
	{
		return Math.sin(x);
	}

	public static void main(String[] args)
	{
		//print out the root of sin(x) that falls between 3 and 4, to within 0.00000001
		FunctionTest functionTest = new FunctionTest();
		System.out.println("The root of sin(x) between x = 3 and x = 4 is " + functionTest.findRoot(3, 4, epsilon));
	}
}