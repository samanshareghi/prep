/*
Cracking Interview - Chapter 2.1
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/
import java.util.*;
class Main
{
	public static void main(String[] args) 
	{
		Node sixth = new Node(2,null);
		Node fifth = new Node(2,sixth);
		Node fourth = new Node(2,fifth);
		Node third = new Node(2,fourth);
		Node second = new Node(2,third);
		Node first = new Node(2,second);

		Node curr = first;
		while(curr!=null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}

		System.out.println("***After remove duplicates***");
		dupsRemoverNoBuff(first);

		curr = first;
		while(curr!=null)
		{
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	public static void dupsRemoverNoBuff(Node curr)
	{
		Node looking, previous, runner;
		int lookingData; 

		looking = curr;

		do{
			previous = looking;
			runner = previous.next;
			lookingData = looking.data;

			while(runner != null)
			{
				if(runner.data == lookingData)
					previous.next = runner.next;
				else
					previous = previous.next;

				runner = previous.next;
			}

			looking = looking.next;

		}while(looking != null);

	}

	public static void dupsRemoverBuff(Node curr)
	{
		if(curr == null || curr.next == null)
			return;

		Node head = curr;
		Hashtable<Integer, Boolean> map = new Hashtable<>();
		int currData, currNextData;

		map.put(curr.data, true);
		
		while(curr.next!=null)
		{
			currNextData = curr.next.data;

			if(map.containsKey(currNextData))
				curr.next = curr.next.next;
			else
			{
				map.put(currNextData,true);
				curr = curr.next;
			}
		}		
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











