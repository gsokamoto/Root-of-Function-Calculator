/*
 * Finds a root of a given 4Newfunction using newton raphson method
 * @author Grant Okamoto
 * @version 1.0
 * 
 */
package IterativeMethods;

public class NewtonRaphson {
	public NewtonRaphson()
	{
		
	}
	
	public double function(double x)
	{
		return 2*x*x*x - 11.7*x*x + 17.7*x - 5; // f(x) = 2x3 – 11.7x2 + 17.7x – 5
		//return x + 10 - x * Math.cosh(50 / x); //f(x) = x + 10 – xcosh(50/x)
	}
	public double functiondx(double x)
	{
		return 6*x*x - 23.4*x + 17.7;
		//return (50*Math.sinh(50/x) - (Math.cosh(50/x) - 1) * x) / x;
	}
	public void run(double initialX)
	{
		double x = initialX;
		double tempX = 0;
		double epsilon = .01;
		double error = 1;
		int iterations = 0;
		
		
		if(functiondx(x) == 0 || Double.isNaN(functiondx(x))|| Double.isNaN(function(x)))
		{
			System.out.println("No solution with given values");
			return;
		}
		while(error >= epsilon)
		{
			if(functiondx(x) == 0)
			{
				System.out.println("The solution may not exist");
				break;
			}
			tempX = x;
			x = x - (function(x)/functiondx(x));
			System.out.println(x);
			if(tempX != 0)
			{
				error = Math.abs((x - tempX) / x);
			}
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
		NewtonRaphson np = new NewtonRaphson();
		np.run(5);
	}
}
