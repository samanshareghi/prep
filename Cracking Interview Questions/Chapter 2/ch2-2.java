/*
Cracking Interview - Chapter 2.2
Implement an algorithm to find the nth to last element of a singly linked list. 
(I'm assuming that in a->b->c->d, a is 3rd to the last and d is 0th to the last, but book assumed d is the 1th to the last and a is 4th to the last)
*/

class Main
{
	public static void main(String[] args) 
	{
		Node fifth = new Node(5,null);
		Node fourth = new Node(4,fifth);
		Node third = new Node(3,fourth);
		Node second = new Node(2,third);
		Node first = new Node(1,second);

		Node retVal = nthFinder(first, 4);

		if(retVal == null)
			System.out.println("Not valid");
		else
			System.out.println(retVal.data);		
	}
	
	public static Node nthFinder(Node head, int nth)
	{	
		if (head == null)
			return null;

		Node nthDistance = head.next; 
		nth--;

		if (nth < 0 && nthDistance==null)
			return head;
		else if (nth<0 && nthDistance!=null)
		{
			while(head.next != null)
				head = head.next;
			return head;
		}

		while(nth!=0)
		{
			nthDistance= nthDistance.next;
			nth--;
		
			if(nthDistance==null)
				return null;
		}

		while(nthDistance.next != null)
		{
			nthDistance = nthDistance.next;
			head = head.next;
		}
		
		return head;
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

