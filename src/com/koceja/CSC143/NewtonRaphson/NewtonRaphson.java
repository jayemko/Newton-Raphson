/*
 * 
 */
package com.koceja.CSC143.NewtonRaphson;

/**
 * Calculates the square and cube roots using the Newton-Raphson method
 * 
 * NewtonRaphson.java
 * @author Jason Koceja
 * @version CSC143 SP12
 */
public class NewtonRaphson {
	static int maxIter = 100;
	static double tolerance = 1e-10;

	/**
	 * Returns the parameter squared
	 * 
	 * @param x The number to square
	 * @return Parameter squared
	 */
	public static double square(double x){
		return x*x;
	}

	/**
	 * Returns the parameter cubed
	 * 
	 * @param x The number to cube
	 * @return Parameter cubed
	 */
	public static double cube(double x){
		return x*x*x;
	}

	/**
	 * Returns the square root of the parameter
	 * 
	 * @param n Number to find square root
	 * @return Square root of parameter
	 * @throws IllegalArgumentException if paramter was negative
	 * @throws java.lang.RuntimeException if maximum iterations was reached without meeting accuracy criterion
	 */
	public static double sqrt(double n){
		double N = n;
		double x = n;
		int count = 1;

		// no negatives
		if (N < 0){
			throw new IllegalArgumentException();
		}
		// square root of zero is zero
		if (N == 0){
			return 0;
		}
		// get to work square-rooting
		do{
			x = (x + (N/x)) / 2.0;
			count++;
		}while(Math.abs((square(x))- N)/N > tolerance && count < maxIter); 
		// if max iterations is reached, throw exception
		if (count == maxIter){
			throw new java.lang.RuntimeException("Iteration did not converge to an answer");
		}
		return x;
	}

	/**
	 * Returns the cube root
	 * 
	 * @param n Number to find cube root
	 * @return Cube root of parameter
	 * @throws java.lang.RuntimeException if maximum iterations was reached without meeting accuracy criterion
	 */
	public static double cbrt(double n){
		double N = n;
		double x = n;
		int count = 1;

		// cube root of zero is zero
		if (n == 0){
			return 0;
		}
		// get to work cube-rooting
		do{
			x = x - ((cube(x)-N)/(3*square(x)));
			count++;
		}while(Math.abs((cube(x)- N)/N) > tolerance && count < maxIter);
		// if max iterations is reached, throw exception
		if (count == maxIter){
			throw new java.lang.RuntimeException("Iteration did not converge to an answer");
		}
		return x;
	}

	/*
	 * Determines parameter at which max iterations is reached
	 */
	public static double max(double n){
		double N = n;

		do{
			N*=1.0001;
			sqrt(N);
	//		cbrt(N);
		}while(sqrt(N)!=100);
	//	}while(cbrt(N)!=100);
		return N;
	}

	//	/*
	//	 * Main method - for method testing
	//	 * 
	//	 * @param args
	//	 */
	//		public static void main(String[] args){
	//			System.out.println(sqrt(6.8e56));
	//			System.out.println(Math.sqrt(1));
	//			System.out.println(cbrt(7.6e24));
	//			System.out.println(Math.cbrt(6));
	//			System.out.println(max(10));
	//		}
}
