//=============================
//Brandon Shearrer
//CS 2 - Assignment 2
//Spring 2018
//=============================


public class Factorial {

	public static long myresult;

	public static void main(String[] args) {

		if (Factorial.calculate(0) == 1) {
			System.out.println("Factorial.calculate(0) returned " + myresult +". Test Passed!");
		}
		else {
			System.out.println("Factorial.calculate(0) failed!");
		}
		if (Factorial.calculate(5) == 120) {
			System.out.println("Factorial.calculate(5) returned " + myresult +". Test Passed!");	
		}
		else {
			System.out.println("Factorial.calculate(0) failed!");
		}
		if (Factorial.calculate(8) == 40320) {
			System.out.println("Factorial.calculate(8) returned " + myresult +". Test Passed!");	
		}
		else {
			System.out.println("Factorial.calculate(0) failed!");
		}
	}

	public static long calculate(long n){
		// First if - else chain to catch human error for factorial.
		if(n < 0) {
			System.out.println("Factorial is not defined for negative numbers!");
			System.exit(0);
		}
		else if(n > 20) {
			System.out.println("Factorial overflow error!");
			System.exit(0);
		} 

		// Second if - else chain to calculate n using the factorial equation
		if(n == 0 || n == 1) {
			myresult = 1;
			return myresult;
		} 
		else {
			myresult = calculate(n-1) * n;
			return myresult;
		}
	}
}