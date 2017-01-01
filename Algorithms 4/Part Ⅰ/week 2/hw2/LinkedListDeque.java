package com.algs4.hw2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<Item> implements Deque<Item>
{
	private Node<Item> first;
	private Node<Item> last;
	private int size;

	public LinkedListDeque()
	{
		this.first = null;
		this.last = null;
		this.size = 0;
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
		Node<Item> oldFirst = first;
		first = new Node<Item>(item, oldFirst);
		if (isEmpty())
			last = first;
		size++;
	}

	@Override
	public void addLast(Item item)
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
	public Item removeFirst()
	{
		checkEmpty();
		Item item = first.item;
		first = first.next;
		size--;
		if (isEmpty())
			last = null;
		return item;
	}

	@Override
	public Item removeLast()
	{
		checkEmpty();
		Item item = last.item;
		Node<Item> cur = first;
		while (cur.next != null && cur.next.next != null)
		{
			cur = cur.next;
		}
		if (last == cur)
		{
			first = last = null;
		}
		else
		{
			last = cur;
			cur.next = null;
		}
		size--;
		return item;
	}

	@Override
	public Iterator<Item> iterator()
	{
		return new DequeIterator<Item>(first);
	}

	@Override
	public String toString()
	{
		String res = "";
		Iterator<Item> it = iterator();
		while (it.hasNext())
		{
			res += it.next() + " ";
		}
		return res.trim();
	}

	private void checkNull(Item item)
	{
		if (item.equals(null))
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

	@SuppressWarnings("hiding")
	private class DequeIterator<Item> implements Iterator<Item>
	{
		private Node<Item> cur;

		public DequeIterator(Node<Item> first)
		{
			this.cur = first;
		}

		@Override
		public boolean hasNext()
		{
			return cur != null;
		}

		@Override
		public Item next()
		{
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = cur.item;
			cur = cur.next;
			return item;
		}

		public void remove()
		{
			throw new UnsupportedOperationException();
		}

	}

	public static void main(String[] args)
	{
		Deque<Integer> deque = new LinkedListDeque<>();

		deque.addFirst(0);
		deque.removeLast(); // ==> 0
		// deque.removeFirst();
		deque.addFirst(2);
		deque.isEmpty();
		deque.removeLast(); // ==> 2
		deque.isEmpty();
		deque.addFirst(6);
		deque.addFirst(7);
		deque.removeLast(); // ==> 6
		deque.addFirst(9);
		deque.removeLast(); // ==> 6

		for (int i = 0; i < 20; i++)
		{
			deque.addLast(i);
		}
		System.out.println(deque);
		int n = 5;
		while (n-- != 0)
		{
			System.out.println(deque.removeFirst());
		}
		System.out.println(deque);
		for (int i = 0; i < 6; i++)
		{
			deque.addFirst(i);
		}
		System.out.println(deque);
		n = 5;
		while (n-- != 0)
		{
			System.out.println(deque.removeLast());
		}
		System.out.println(deque);
		Iterator<Integer> it = deque.iterator();
		while (it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println("\n" + deque);
	}
}
