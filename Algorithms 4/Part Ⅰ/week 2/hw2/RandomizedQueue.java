package com.algs4.hw2;

import java.util.Iterator;

public interface RandomizedQueue<Item> extends Iterable<Item>
{
	boolean isEmpty(); // is the queue empty?

	int size(); // return the number of items on the queue

	void enqueue(Item item); // add the item

	Item dequeue(); // remove and return a random item

	Item sample(); // return (but do not remove) a random item

	Iterator<Item> iterator(); // return an independent iterator over items in
	                           // random order
}
