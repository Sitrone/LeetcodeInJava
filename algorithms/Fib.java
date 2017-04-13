package com.algs;

public class Fib
{
	/**
	 * Recursive
	 */
	public static int fib(int n)
	{
		if (0 == n)
		{
			return 0;
		}
		else if (1 == n)
		{
			return 1;
		}
		else
		{
			return fib(n - 1) + fib(n - 2);
		}
	}

	/**
	 * tail recursive
	 * 
	 * @param args
	 */
	public static int fib2(int n)
	{
		return fib2Helper(1, 0, n);
	}

	private static int fib2Helper(int a, int b, int n)
	{
		if (n == 0)
		{
			return b;
		}
		return fib2Helper(a + b, a, n - 1);
	}

	/**
	 * while
	 * 
	 * @param args
	 */
	public static int fib3(int n)
	{
		if (0 == n)
		{
			return 0;
		}
		else if (1 == n)
		{
			return 1;
		}
		int a = 1, b = 0;
		while (n-- > 0)
		{
			int temp = a;
			a = a + b;
			b = temp;
		}
		return b;
	}
	
	/**
	 * 自底向上包含"动态规划"思想的解法
	 * 
	 * @param n
	 * @return 第n个斐波那契数
	 */
	public static long downToTopReslove(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else if (n == 1)
		{
			return 1;
		}
		else
		{
			long[] fibonacciArray = new long[n + 1]; // fibonacciArray[i]表示第i个斐波那契数
			fibonacciArray[0] = 0;
			fibonacciArray[1] = 1;
			for (int i = 2; i <= n; i++)
			{ 
				// 注意由于fibonacciArray[0]表示第0个元素，这里是i <= n，而不是i < n
				fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
			}

			return fibonacciArray[fibonacciArray.length - 1];
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(downToTopReslove(100));
	}
}
