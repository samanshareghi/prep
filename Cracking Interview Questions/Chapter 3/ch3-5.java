/*
Cracking Interview - Chapter 3.5
Implement a MyQueue class which implements a queue using two stacks.
*/

import java.util.*;

class Main
{
	public static void main(String[] args) 
	{
		MyQueue q = new MyQueue();
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(1);
		// System.out.println(q.size());
		System.out.println(q.deQueue());
		q.enQueue(10);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}

class MyQueue
{
	Stack<Integer> firstStack;
	Stack<Integer> secondStack;

	public MyQueue()
	{
		firstStack = new Stack<>();
		secondStack = new Stack<>();
	}

	public void enQueue(Integer data)
	{
		firstStack.push(data);
	}

	public Integer deQueue()
	{
		if(firstStack.isEmpty())
			return null;

		while(!firstStack.isEmpty())
			secondStack.push(firstStack.pop());

		int retVal = secondStack.pop();

		while(!secondStack.isEmpty())
			firstStack.push(secondStack.pop());

		return retVal;
	}

	public int size()
	{
		return firstStack.size();
	}
}