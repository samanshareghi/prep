/*
Cracking Interview - Chapter 3.6

Write a program to sort a stack in ascending order. You should not make any assump-
tions about how the stack is implemented. The following are the only functions that
should be used to write this program: push | pop | peek | isEmpty.
*/

import java.util.*;

class Main
{
	public static void main(String[] args) 
	{
		MyStack s = new MyStack();

		s.push(3);
		s.push(2);
		s.push(4);
		s.push(6);
		s.push(2);
		s.push(1);
		s.push(0);
		s.push(7);
		s.push(8);
		s.push(5);


		while(!s.isEmpty())
			System.out.println(s.pop());

		s.push(3);
		s.push(2);
		s.push(4);
		s.push(6);
		s.push(2);
		s.push(1);
		s.push(0);
		s.push(7);
		s.push(8);
		s.push(5);
	
		System.out.println("**********");
	
		s.orderStack();	

		while(!s.isEmpty())
			System.out.println(s.pop());
	}
}

class MyStack extends Stack<Integer>
{
	public void orderStack()
	{
		if(this.isEmpty())
			return;

		Stack<Integer> helperStack = new Stack<>();
		int thisVal, helperVal;

		helperStack.push(this.pop());

		while(!this.isEmpty())
		{
			
			thisVal = this.pop();
			helperVal = helperStack.peek();

			while(thisVal > helperVal)
			{	
				this.push(helperStack.pop());
				if(helperStack.isEmpty())
					break;	
				helperVal = helperStack.peek();
			}

			helperStack.push(thisVal);
		}

		while(!helperStack.isEmpty())
			this.push(helperStack.pop());
	}
}

