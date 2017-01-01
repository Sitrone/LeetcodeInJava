package com.algs4.hw2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<Item> implements Deque<Item>
{
	private static final int INIT_SIZE = 10;
	private Item[] elements;
	private int front;
	private int back;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayDeque()
	{
		elements = (Item[]) new Object[INIT_SIZE];
		size = 0;
		front = 0;
		back = 0;
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
	public void addFirst(Item item)
	{
		checkNull(item);
		if(isFull()) resize(2 * elements.length);
		
		elements[front] = item;
		front = decrement(front);
		size++;
	}

	@Override
	public void addLast(Item item)
	{
		checkNull(item);
		if(isFull()) resize(2 * elements.length);
		
		elements[back] = item;
		back = increment(back);
		size++;
	}

	@Override
	public Item removeFirst()
	{
		checkEmpty();
		
		front = increment(front);
		Item first = elements[front];
		elements[front] = null;
		size--;
		if(size > 0 && size < elements.length / 4) resize(elements.length / 2);
		return first;
	}

	@Override
	public Item removeLast()
	{
		checkEmpty();
		
		back = decrement(back);
		Item last = elements[back];
		elements[back] = null;
		size--;
		if(size > 0 && size < elements.length / 4) resize(elements.length / 2);
		return last;
	}

	@Override
	public Iterator<Item> iterator()
	{
		return new DequeIterator<>(back, size);
	}
	
	
	@Override
	public String toString()
	{
		return "ArrayDeque [elements=" + Arrays.toString(elements) + ", front=" + front + ", back=" + back + ", size="
		        + size + "]";
	}

	@SuppressWarnings("hiding")
	private class DequeIterator<Item> implements Iterator<Item>
	{
		private int cur;
		private int n;
		
		public DequeIterator(int back, int n)
		{
			this.cur = back;
			this.n = n;
		}
		@Override
		public boolean hasNext()
		{
			return n == 0;
		}

		@Override
		public Item next()
		{
			@SuppressWarnings("unchecked")
			Item item = (Item) elements[cur];
			cur = increment(cur);
			n--;
			return item;
		}
		
	}
	
	private void resize(int len)
	{
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[len];
		for(int i = 0; i < size; i++)
		{
			temp[i] = elements[(front + i) % elements.length];
		}
		front = 0;
		back = size;
		elements = temp;
	}
	
	private int increment(int x)
	{
		return ++x == elements.length ? 0 : x;
	}
	
	private int decrement(int x)
	{
		return --x == -1 ? elements.length - 1 : x;
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
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
	}
	
	private boolean isFull()
	{
		return size == elements.length;
	}
	


	public static void main(String[] args)
	{
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 0; i < 20; i++)
		{
			deque.addLast(i);
		}
		System.out.println(deque);
		int n = 5;
		while(n-- != 0)
		{
			System.out.println(deque.removeFirst());
		}
		System.out.println(deque);
		for(int i = 0; i < 6; i++)
		{
			deque.addFirst(i);
		}
		System.out.println(deque);
		n = 5;
		while(n-- != 0)
		{
			System.out.println(deque.removeLast());
		}
		System.out.println(deque);
	}
}
