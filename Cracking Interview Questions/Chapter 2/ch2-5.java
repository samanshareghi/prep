/*
Cracking Interview - Chapter 2.5
Given a circular linked list, implement an algorithm which returns node at the begin-
ning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
earlier node, so as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
*/

class Main 
{
	public static void main(String[] args) 
	{
		Node e = new Node( 5, null);
		Node d = new Node( 4, e);
		Node c = new Node( 3, d);
		Node b = new Node( 2, c);
		Node a = new Node( 1, b);
		e.next = e;
		
		Node result = circleFinder(a);
		System.out.println(( result== null ? "not circular" : result.data));
		
	}

	public static Node circleFinder (Node head)
	{
		if(head == null || head.next == null || head.next.next == null)
			return null;

		Node doubleRunner = head;
		Node singleRunner = head;
		doubleRunner = doubleRunner.next.next;
		singleRunner = singleRunner.next;
		
		while(doubleRunner != singleRunner)
		{
			if(doubleRunner.next == null || doubleRunner.next.next == null)
				return null;

			doubleRunner = doubleRunner.next.next;
			singleRunner = singleRunner.next;
		}
		
		doubleRunner = head;

		while(doubleRunner != singleRunner)
		{
			doubleRunner = doubleRunner.next;
			singleRunner = singleRunner.next;
		}

		return singleRunner;
	}

	private static class Node
	{	
		public int data;
		public Node next;

		public Node(int data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	} 

}