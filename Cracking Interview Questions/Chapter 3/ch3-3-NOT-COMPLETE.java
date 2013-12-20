/*
Cracking Interview - Chapter 3.3

Imagine a (literal) stack of plates. If the stack gets too high, it might topple. There-
fore, in real life, we would likely start a new stack when the previous stack exceeds
some threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
Stacks should be composed of several stacks, and should create a new stack once
the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should
behave identically to a single stack (that is, pop() should return the same values as it
would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific
sub-stack.

This is without popAt(). Saved for later practices
*/

import java.util.*;

class Main
{
	public static void main(String[] args) 
	{
		SetOfStacks myStack = new SetOfStacks(3);

		myStack.push(1);
		myStack.push(4);
		myStack.push(5);
		myStack.push(2);
		myStack.push(6);

		// System.out.println(myStack.size());
		System.out.println(myStack.pop());


	}
}

class SubStack extends Stack<Integer>
{
	private LinkedList<Integer> subStack;
	public SubStack()
	{
		subStack = new LinkedList<>();
	}

	public Integer push(int data)
	{
		subStack.add(data);
		return data;
	}

	public Integer pop()
	{
		return subStack.removeLast();
	}

	public int size()
	{
		return subStack.size();
	}
}

class SetOfStacks 
{
	private LinkedList<SubStack> setHolder;
	private int threshold;
	public SetOfStacks(int threshold)
	{
		this.threshold = threshold;
		setHolder = new LinkedList<>();
	}

	public void push(int data)
	{
		if(setHolder.isEmpty())
		{
			SubStack newStack = new SubStack();
			newStack.push(data);
			setHolder.addLast(newStack);
			return;
		}

		SubStack lastStack = setHolder.getLast();

		if(threshold > lastStack.size())
			lastStack.push(data);
		else
		{
			SubStack newStack = new SubStack();
			newStack.push(data);
			setHolder.addLast(newStack);
		}
	}

	public Integer pop()
	{
		if(setHolder.isEmpty())
			return null;

		SubStack lastStack = setHolder.getLast();
		int retVal = lastStack.pop();

		if(lastStack.size() == 0)
			setHolder.removeLast();
		return retVal;
	}


	public int size()
	{
		return setHolder.size();
	}
}
