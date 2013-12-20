/*
Cracking Interview - Chapter 2.3

Implement an algorithm to delete a node in the middle of a single linked list, given
only access to that node.
EXAMPLE
Input: the node ‘c’ from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a->b->d->e

NOTE: This problem can not be solved if the node to be deleted is the last node
in the linked list. That’s ok—your interviewer wants to see you point that out. You
could consider marking it as dummy in that case. This is an issue you should dis-
cuss with your interviewer.
*/

class Main
{
	public static void main(String[] args) 
	{
		Node sixth = new Node(6,null);
		Node fifth = new Node(5,sixth);
		Node fourth = new Node(4,fifth);
		Node third = new Node(3,fourth);
		Node second = new Node(2,third);
		Node first = new Node(1,second);

		Node curr = first;
		while(curr!=null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}

		System.out.println("***removing***");
		boolean rmSuccess = remove(fifth);
		rmSuccess = remove(fourth);
		rmSuccess = remove(third);
		rmSuccess = remove(third);
		rmSuccess = remove(fourth);
		rmSuccess = remove(third);
		

		// rmSuccess = remove(second);
		// rmSuccess = remove(first);
		// rmSuccess = remove(sixth);
		// rmSuccess = remove(first);
		curr = first;

		while(curr!=null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}		
	}

	public static boolean remove(Node toBeRemoved)
	{
		if(toBeRemoved.next == null)
			return false;
		toBeRemoved.data = toBeRemoved.next.data;
		toBeRemoved.next = toBeRemoved.next.next;

		return true;
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