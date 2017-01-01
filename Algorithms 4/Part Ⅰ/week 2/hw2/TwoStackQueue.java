package com.algs4.hw2;

import java.util.Stack;

public class TwoStackQueue<E>
{
	// interview questions
	private Stack<E> inbox = new Stack<E>();
	private Stack<E> outbox = new Stack<E>();

	public void queue(E item)
	{
		inbox.push(item);
	}

	public E dequeue()
	{
		if (outbox.isEmpty())
		{
			while (!inbox.isEmpty())
			{
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}
}
