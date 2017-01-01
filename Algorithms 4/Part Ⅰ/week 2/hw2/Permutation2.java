package com.algs4.hw2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation2
{
	public static void main(String[] args)
	{
		int k = Integer.parseInt(args[0]);
		int cur = 0;

		String[] res = new String[k];
		while (!StdIn.isEmpty())
		{
			String input = StdIn.readString();
			if (cur < k)
			{
				res[cur] = input;
			}
			else
			{
				int r = StdRandom.uniform(cur + 1);
				if (r < k)
					res[r] = input;
			}
			cur++;
		}

		for (String s : res)
		{
			StdOut.println(s);
		}

	}
}
