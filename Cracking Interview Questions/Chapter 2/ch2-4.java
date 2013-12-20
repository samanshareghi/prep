/*
Cracking Interview - Chapter 2.4
You have two numbers represented by a linked list, where each node contains a sin-
gle digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
the list. Write a function that adds the two numbers and returns the sum as a linked
list.
EXAMPLE
Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
Output: 8 -> 0 -> 8


Not completed, gotta fix it later
*/

class Main
{
	public static void main(String[] args) 
	{	
		Node fff = new Node(0, 5, null);
		Node ff = new Node(0, 1, fff);
		Node f = new Node(0, 3, ff);
		Node sss= new Node(0,2, null);
		Node ss= new Node(0,9, sss);
		Node s= new Node(0,5, ss);

		Node result = add(f, s, 0);

		while(result!=null)
		{
			System.out.print(result.data + " ");
			result = result.next;
		}
		System.out.println();

	}

	public static Node add(Node firstNum, Node secondNum, int carry)
	{

		if (firstNum == null && secondNum == null)
			return null;
			
		Node result = new Node(carry, 0, null);
			
		int value = carry;
			
		if (firstNum != null)
			value += firstNum.data;
			
		if (secondNum != null)
			value += secondNum.data;
			
		result.data = value % 10;
			
		Node more = add(firstNum == null ? null : firstNum.next, secondNum == null ? null : secondNum.next, value > 10 ? 1 : 1);
			
		result.next = more;
			
		return result;
	}

	private static class Node
	{	
		public int data;
		public Node next;

		public Node(int carry, int data, Node next)
		{
			this.data = data + carry;
			this.next = next;
		}
	} 
}