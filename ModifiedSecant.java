/*
 * Finds a root of a given function using the modified secant method
 * @author Grant Okamoto
 * @version 1.0
 * 
 */
package IterativeMethods;

public class ModifiedSecant{

	public ModifiedSecant()
	{
		
	}
	
	public double function(double x)
	{
		return 2*x*x*x - 11.7*x*x + 17.7*x - 5; // f(x) = 2x3 – 11.7x2 + 17.7x – 5
		//return x + 10 - x * Math.cosh(50 / x); //f(x) = x + 10 – xcosh(50/x)
		
	}
	
	public void run(double initialA)
	{
		double a = initialA;
		double b = 0;
		double epsilon = .01;
		double error = 1;
		int iterations = 0;

		while(error >= epsilon)
		{
			if(function(a+a*epsilon)-function(a) == 0 || Double.isNaN(function(a+a*epsilon)-function(a)))
			{
				System.out.println("No solution with given values");
				break;
			}
			b = a - ((epsilon*a*function(a)/(function(a+a*epsilon)-function(a))));
			if(b != 0)
			{
				error = Math.abs((b - a) / b);
			}
			System.out.println(b);
			a = b;
			if(iterations >= 100)
			{
				System.out.println("Solution not found");
				break;
			}
			iterations++;
		}
	}
	
	public static void main(String[] args)
	{
		ModifiedSecant ms = new ModifiedSecant();
		ms.run(3);
	}
}
