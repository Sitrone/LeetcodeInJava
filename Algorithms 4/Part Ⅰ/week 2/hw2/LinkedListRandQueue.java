package com.algs4.hw2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class LinkedListRandQueue<Item> implements RandomizedQueue<Item>
{
	private Node<Item> first;
	private Node<Item> last;
	private int size;

	public boolean isEmpty()
	{
		return size == 0;
	}

	public int size()
	{
		return size;
	}

	@Override
	public void enqueue(Item item)
	{
		checkNull(item);
		Node<Item> oldLast = last;
		last = new Node<Item>(item, null);

		if (isEmpty())
			first = last;
		else
			oldLast.next = last;
		size++;
	}

	@Override
	public Item dequeue()
	{
		checkEmpty();
		Node<Item> cur = first;
		Node<Item> sample = sampleNode();
		if (cur.equals(sample))
		{
			first = first.next;
			size--;
			if (isEmpty())
				last = null;
			return sample.item;
		}

		while (!cur.next.equals(sample))
		{
			cur = cur.next;
		}
		if (cur.next.next != null)
			cur.next = cur.next.next;
		else
		{
			cur.next = null;
			last = cur;
		}
		size--;
		return sample.item;
	}

	@Override
	public Item sample()
	{
		return sampleNode().item;
	}

	private Node<Item> sampleNode()
	{
		checkEmpty();
		int rand = StdRandom.uniform(size);
		Node<Item> cur = first;
		while (rand-- != 0)
		{
			cur = cur.next;
		}
		return cur;
	}

	@Override
	public Iterator<Item> iterator()
	{
		return new RandQueueIterator<>();
	}

	@SuppressWarnings("hiding")
	private class RandQueueIterator<Item> implements Iterator<Item>
	{
		private Item[] arr;
		private int index;

		@SuppressWarnings("unchecked")
		public RandQueueIterator()
		{
			arr = (Item[]) new Object[size];
			index = 0;
			Node<Item> cur = (Node<Item>) first;
			for(int i = 0; i < size; i++)
			{
				arr[i] = cur.item;
				cur = cur.next;
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
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	private void checkNull(Item item)
	{
		if (item == null)
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

	@Override
	public String toString()
	{
		String res = "";
		Node<Item> cur = first;
		int n = this.size;
		while (n-- != 0)
		{
			res += cur.item + " ";
			cur = cur.next;
		}
		return res;
	}

	public static void main(String[] args)
	{
		RandomizedQueue<Integer> randq = new LinkedListRandQueue<>();
		for(int i = 0; i < 10; i++)
		{
			randq.enqueue(i);
		}
		System.out.println(randq.size());
		System.out.println(randq);
		
		int n = 5;
		while (n-- != 0)
		{
			System.out.print (randq.dequeue() + " ");
		}
		
		Iterator<Integer> it = randq.iterator();
		System.out.println();
		while(it.hasNext())
		{
			System.out.print(it.next() + " ");
		}

	}
}
