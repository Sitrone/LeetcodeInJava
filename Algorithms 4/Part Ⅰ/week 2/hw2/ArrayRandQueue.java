package com.algs4.hw2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class ArrayRandQueue<Item> implements RandomizedQueue<Item>
{
	private static final int INIT_SIZE = 4;
	
	private Item[] elements;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayRandQueue()
	{
		elements = (Item[]) new Object[INIT_SIZE];
		size = 0;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public void enqueue(Item item)
	{
		checkNull(item);
		if(isFull()) resize(2 * elements.length);
		
		elements[size++] = item;
	}

	@Override
	public Item dequeue()
	{
		checkEmpty();
		int randIndex = StdRandom.uniform(size);
		Item item = elements[randIndex];
		
		// exchange the last element with randIndex
		elements[randIndex] = elements[--size];
		elements[size] = null;
		
		if(size > 0 && size == elements.length/4) resize(elements.length / 2);
		return item;
	}

	public Item sample()
	{
		checkEmpty();
		return elements[StdRandom.uniform(size)];
	}

	@Override
	public Iterator<Item> iterator()
	{
		return new ListIterator<>(elements);
	}
	
	
	@SuppressWarnings("hiding")
	private class ListIterator<Item> implements Iterator<Item>
	{
		private Item[] arr;
		private int index;
		
		@SuppressWarnings("unchecked")
		public ListIterator(Object[] elements)
		{
			arr = (Item[]) new Object[size];
			index = 0;
			for(int i = 0; i < size; i++)
			{
				arr[i] = (Item) elements[i];
			}
			StdRandom.shuffle(arr);
		}

		@Override
		public boolean hasNext()
		{
			return index != size;
		}

		@Override
		public Item next()
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			return arr[index++];
		}
	}

	private void resize(int len)
	{
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[len];
		for (int i = 0; i < size; i++)
		{
			temp[i] = elements[i];
		}
		elements = temp;
	}
	
	private void checkNull(Item item)
	{
		if(item.equals(null))
		{
			throw new NullPointerException();
		}
	}
	
	private void checkEmpty()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
	}
	
	private boolean isFull()
	{
		return size == elements.length;
	}
	
	@Override
	public String toString()
	{
		String res = "";
		for (int i = 0; i < size; i++)
		{
			res += elements[i] + " ";
		}
		return res.trim();
	}

	public static void main(String[] args)
	{
		RandomizedQueue<Integer> r = new ArrayRandQueue<>();
		for(int i = 0; i < 12; i++)
		{
			r.enqueue(i);
		}
		System.out.println(r.size());
		System.out.println(r);
		int n = 5;
		while(n-- != 0)
		{
			System.out.println(r.dequeue());
		}
		
		Iterator<Integer> it = r.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println("\n" + r);
	}
}
