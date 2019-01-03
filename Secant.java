/*
 * Finds a root of a given function using the secant method
 * @author Grant Okamoto
 * @version 1.0
 * 
 */
package IterativeMethods;

public class Secant{

	public Secant()
	{
		
	}
	
	public double function(double x)
	{
		return 2*x*x*x - 11.7*x*x + 17.7*x - 5; // f(x) = 2x3 – 11.7x2 + 17.7x – 5
		//return x + 10 - x * Math.cosh(50 / x); //f(x) = x + 10 – xcosh(50/x)
	}
	
	public void run(double initialA, double initialB)
	{
		double a = initialA;
		double b = initialB;
		double c = 0;
		double tempC = 0;
		double epsilon = .01;
		double error = 1;
		int iterations = 0;
		
		while(error >= epsilon)
		{
			if(function(b) - function(a) == 0)
			{
				System.out.println("No solution with given values");
				break;
			}
			tempC = c;
			c = b - (function(b) * (b - a) / (function(b) - function(a)));
			if(tempC != 0)
			{
				error = Math.abs((c - tempC) / c);
			}
			System.out.println(c);
			a = b;
			b = c;
			iterations++;
			if(iterations >= 100)
			{
				System.out.println("Solution not found");
				break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Secant s = new Secant();
		s.run(3, 4);
	}
}
