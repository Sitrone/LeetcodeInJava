package com.algs4.hw2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinkedListDeque<Item> implements Deque<Item>
{
	private DLinkNode<Item> head;
	private int size;
	
	
	// create a sentinel
	@SuppressWarnings("unchecked")
	public DLinkedListDeque()
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
	public void addFirst(Item item) throws NullPointerException
	{
		checkNull(item);
		DLinkNode<Item> front = new DLinkNode<Item>(item, head, head.next);
		head.next.prev = front;
		head.next = front;
		size++;
	}

	@Override
	public void addLast(Item item) throws NullPointerException
	{
		checkNull(item);
		DLinkNode<Item> back = new DLinkNode<Item>(item, head.prev, head);
		head.prev.next = back;
		head.prev = back;
		size++;
	}

	@Override
	public Item removeFirst() throws NoSuchElementException
	{
		checkEmpty();
		DLinkNode<Item> first = head.next;
		Item firstItem = first.item;
		
		head.next = head.next.next;
		head.next.prev = head;
		first.remove();
		size--;
		return firstItem;
	}

	@Override
	public Item removeLast() throws NoSuchElementException
	{
		checkEmpty();
		DLinkNode<Item> last = head.prev;
		Item lastItem = last.item;
		
		head.prev = head.prev.prev;
		head.prev.next = head;
		last.remove();
		size--;
		return lastItem;
	}

	@Override
	public Iterator<Item> iterator()
	{
		return new ListDeque<>(head.next);
	}
	
	@SuppressWarnings("hiding")
	private class ListDeque<Item> implements Iterator<Item>
	{
		private DLinkNode<Item> cur;
		
		public ListDeque(DLinkNode<Item> first)
		{
			this.cur = first;
		}

		@Override
		public boolean hasNext()
		{
			return cur != head;
		}

		@Override
		public Item next()
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			Item item = cur.item;
			cur = cur.next;
			return item;
		}
		
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
	
	@Override
	public String toString()
	{
        String result = "[  ";
        DLinkNode<Item> cur = head.next;
        while (cur != head)
        {
            result = result + cur.item + "  ";
            cur = cur.next;
        }
        return result + "]";
	}

	public static void main(String[] args)
	{
		Deque<Integer> deque = new DLinkedListDeque<>();
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
		Iterator<Integer> it = deque.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println("\n" + deque);
	}
}
