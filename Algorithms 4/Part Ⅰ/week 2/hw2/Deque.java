package com.algs4.hw2;

import java.util.Iterator;

public interface Deque<Item> extends Iterable<Item>
{
	boolean isEmpty(); // is the deque empty?

	int size(); // return the number of items on the deque

	void addFirst(Item item); // add the item to the front

	void addLast(Item item); // add the item to the end

	Item removeFirst(); // remove and return the item from the front

	Item removeLast(); // remove and return the item from the end

	Iterator<Item> iterator(); // return an iterator over items in order from
	                           // front to end
}
