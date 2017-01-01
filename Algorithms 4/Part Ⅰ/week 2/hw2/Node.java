package com.algs4.hw2;

public class Node<Item>
{
	Item item;
	Node<Item> next;
	
	public Node(Item item, Node<Item> next)
	{
		this.item = item;
		this.next = next;
	}
	
	@Override
	public String toString()
	{
		return "Node [item=" + item + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Node<Item> other = (Node<Item>) obj;
		if (item == null)
		{
			if (other.item != null)
				return false;
		}
		else if (!item.equals(other.item))
			return false;
		if (next == null)
		{
			if (other.next != null)
				return false;
		}
		else if (!next.equals(other.next))
			return false;
		return true;
	}
	
	
}
