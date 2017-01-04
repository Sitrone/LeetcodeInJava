package com.algs4.hw2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class DLinkedListRandQueue<Item> implements RandomizedQueue<Item>
{
	private DLinkNode<Item> head;
	private int size;
	
	@SuppressWarnings("unchecked")
	public DLinkedListRandQueue()
	{
		head = new DLinkNode<Item>((Item) "", null, null);
		head.next = head;
		head.prev = head;
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
		DLinkNode<Item> back = new DLinkNode<Item>(item, head.prev, head);
		head.prev.next = back;
		head.prev = back;
		size++;
	}

	@Override
	public Item dequeue()
	{
		DLinkNode<Item> d = sampleNode();
		Item item = d.item;
		d.next.prev = d.prev;
		d.prev.next = d.next;
		d.remove();
		size--;
		return item;
	}

	@Override
	public Item sample()
	{
		return sampleNode().item;
	}
	
	private DLinkNode<Item> sampleNode()
	{
		int rand = StdRandom.uniform(size);
		DLinkNode<Item> cur = head.next;
		while(cur != head && rand-- != 0)
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
			DLinkNode<Item> cur = (DLinkNode<Item>) head.next;
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
			return (Item) arr[index++];
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
	}
	
	private void checkNull(Item item)
	{
		if(item.equals(null))
		{
			throw new NullPointerException();
		}
	}
	
	public static void main(String[] args)
	{
		RandomizedQueue<Integer> randq = new DLinkedListRandQueue<>();
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
