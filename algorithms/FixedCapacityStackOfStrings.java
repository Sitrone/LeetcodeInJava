package com.algs;

public class FixedCapacityStackOfStrings<Item> {
	private Item[] a;       //Stack entries
	private int N;			//Stack size
	
	public FixedCapacityStackOfStrings(int cap)
	{
		a = (Item[]) new Object[cap];
	}
	
	private void resize(int max)
	{
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < N; i++)
		{
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size(int N)
	{
		return N;
	}
	
	public void push(Item item)
	{
		if(N == a.length)
		{
			resize(2 * a.length);
		}
		a[N++] = item;
	}
	
	public Item pop()
	{
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length /4 )
		{
			resize(a.length / 2);
		}
		return item;
	}
}
