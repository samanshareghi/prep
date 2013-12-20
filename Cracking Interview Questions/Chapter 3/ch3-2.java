/*
Cracking Interview - Chapter 3.2

How would you design a stack which, in addition to push and pop, also has a function
min which returns the minimum element? Push, pop and min should all operate in
O(1) time.
*/

import java.util.*;

class Main
{
	public static void main(String[] args) 
	{
		Node h = new Node(1);
		Node g = new Node(0);
		Node f = new Node(10);
		Node e = new Node(5);
		Node d = new Node(2);
		Node c = new Node(-1);
		Node b = new Node(1);
		Node a = new Node(3);

		MyStack stackBazi = new MyStack();
		stackBazi.push(a);
		stackBazi.push(b);
		stackBazi.push(c);
		stackBazi.push(d);
		stackBazi.push(e);
		stackBazi.push(f);
		stackBazi.push(g);
		stackBazi.push(h);

		stackBazi.pop();
		stackBazi.pop();
		stackBazi.pop();
		
		int result = stackBazi.min();
		System.out.println((result == Integer.MAX_VALUE ? "Nothing in the stack yet" : result));
	}
}

class Node
{
	public int data, min;
	public Node(int data)
	{
		this.data = data;
		min = Integer.MAX_VALUE;
	}
}

class MyStack extends Stack<Node>
{
	private LinkedList<Node> mainStack;
	public MyStack()
	{
		mainStack = new LinkedList<>();
	}

	public Node push(Node n)
	{
		int minSoFar;
		if(mainStack.isEmpty())
			minSoFar = n.data;
		else
			minSoFar = mainStack.getLast().min;

		n.min = (minSoFar<n.data ? minSoFar : n.data);
		mainStack.addLast(n);

		return n;
	}

	public Node pop()
	{
		Node retVal = mainStack.removeLast();
		if(retVal == null)
			return null;

		return retVal; 
	}

	public int min()
	{
		return (mainStack.isEmpty() ? Integer.MAX_VALUE : mainStack.getLast().min); 
	}
}