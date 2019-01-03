/*
 * Finds a root of a given function using the bisection method
 * @author Grant Okamoto
 * @version 1.0
 * 
 */
package IterativeMethods;

public class Bisection {

	public Bisection()
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
		
		if(function(a) * function(b) > 0)
		{
			System.out.println("A and B are invalid inputs");
			return;
		}
		while(error >= epsilon)
		{
			tempC = c;
			c = (a + b) / 2;
			if(function(c) == 0)
			{
				break;
			}
			if(isPositive(function(a)*function(c)))
			{
				a = c;
			}
			else
			{
				b = c;
			}
			if(tempC != 0)
			{
				error = Math.abs((c - tempC) / c);
			}
			System.out.println(c);
			iterations++;
			if(iterations >= 100)
			{
				System.out.println("Solution not found");
				break;
			}
		}
	}

	public boolean isPositive(double value)
	{
		if(value >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		Bisection bm = new Bisection();
		bm.run(1, 3);
	}
}
