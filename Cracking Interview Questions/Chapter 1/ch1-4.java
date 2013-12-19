/*
Cracking interview - chapter 1.4
Write a method to decide if two strings are anagrams or not.
*/

import java.util.*;
class Main
{
	public static void main(String [] args)
	{

		//Doesn't accept space or any other special characters
		char[] first = "Thepublicartgalleries".toCharArray();
		char[] second = "largepicturehallsibeT".toCharArray();

		System.out.println(buff(first,second));
		System.out.println(noBuff(first,second));		
	}

	public static boolean buff(char[] first, char[] second)
	{
		if(first.length != second.length)
			return false;

		int[] asciiArr = new int[256];
		Arrays.fill(asciiArr, 0);

		for(char c : first)
			asciiArr[c]++;
		
		for(char c: second)
			if(asciiArr[c]==0)
				return false;
			else
				asciiArr[c]--; 

		return true;
	}

	public static boolean noBuff(char[] first, char[] second)
	{
		if(first.length != second.length)
			return false;

		Arrays.sort(first);
		Arrays.sort(second);

		for(int i=0; i<first.length; i++)
			if(first[i]!=second[i]) return false;

		return true;
	}
}