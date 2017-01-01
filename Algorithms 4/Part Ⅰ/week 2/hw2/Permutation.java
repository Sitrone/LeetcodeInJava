package com.algs4.hw2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation
{

	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		
		RandomizedQueue<String> rand = new LinkedListRandQueue<>();
		while(!StdIn.isEmpty())
		{
			rand.enqueue(StdIn.readString());
		}
		
		while(n-- != 0)
		{
			StdOut.print(rand.dequeue());
		}

	}

}
