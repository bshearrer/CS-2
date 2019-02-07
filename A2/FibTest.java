//=============================
//Brandon Shearrer
//CS 2 - Assignment 2
//Spring 2018
//=============================

public class FibTest
{
	public static int testnum;

	public static int fibIter(int n)
	{
		//iterative fib calculator
		if (n == 0) return 0;	
		else if (n == 1) return 1;

		int n1 = 1;
  		int n2 = 0;
  		int result = 0;

  		for(int i = 2; i <= n; i++) 
  		{
	   		result = n1 + n2;
	    	n2 = n1;
	    	n1 = result;
    	}
    	return result;
	}

	public static int fibRecur(int n)
	{
		if (n == 0) return 0;	
		else if (n == 1) return 1;	
		else return fibRecur(n-1) + fibRecur(n-2);
	}

	public static void main(String[] args)
	{
		long startTimeRecur;
		long startTimeIter;
		long resultIter;
		long resultRecur;
		long endTimeRecur;
		long endTimeIter;
		long totalTimeIter;
		long totalTimeRecur;
		//Tests for fib(3)
		if (fibIter(3) == 2) {
			System.out.println("fibIter(3) = 2. Test Passed!"); 
		}
		else {
			System.out.println("fibIter(3) Test Failed!");
		}
		if (fibRecur(3) == 2) {
			System.out.println("fibRecur(3) = 2. Test Passed!");
		}
		else {
			System.out.println("fibRecur(3) Test Failed!");
		}

		//Tests for fib(6)
		if (fibIter(6) == 8) {
			System.out.println("fibIter(6) = 8. Test Passed!"); 
		}
		else {
			System.out.println("fibIter(6) Test Failed!");
		}
		if (fibRecur(6) == 8) {
			System.out.println("fibRecur(6) = 8. Test Passed!");
		}
		else {
			System.out.println("fibRecur(6) Test Failed!");
		}

		//Tests for fib(12)
		if (fibIter(12) == 144) {
			System.out.println("fibIter(12) = 144. Test Passed!"); 
		}
		else {
			System.out.println("fibIter(12) Test Failed!");
		}
		if (fibRecur(12) == 144) {
			System.out.println("fibRecur(12) = 144. Test Passed!");
		}
		else {
			System.out.println("fibRecur(12) Test Failed!");
		}
		
		startTimeIter = System.currentTimeMillis();
		resultIter = FibTest.fibIter(40);
		endTimeIter = System.currentTimeMillis();
		totalTimeIter = endTimeIter - startTimeIter;
		System.out.println("Time it took to execute FibTest.fibIter(40) = " + totalTimeIter + ".");

		startTimeRecur = System.currentTimeMillis();
		resultRecur = FibTest.fibRecur(40);
		endTimeRecur = System.currentTimeMillis();
		totalTimeRecur = endTimeRecur - startTimeRecur;
		System.out.println("Time it took to execute FibTest.fibRecur(40) = " + totalTimeRecur + ".");
	}	
}