package com.algs4.hw2;

public class DLinkNode<Item>
{
	Item item;
	DLinkNode<Item> next;
	DLinkNode<Item> prev;
	
	public DLinkNode(Item item,DLinkNode<Item> prev, DLinkNode<Item> next)
	{
		this.item = item;
		this.next = next;
		this.prev = prev;
	}
	
	public void remove()
	{
		this.next = null;
		this.prev = null;
	}

	@Override
	public String toString()
	{
		return "DNode [item=" + item + ", next=" + next + ", prev=" + prev + "]";
	}
	
}
