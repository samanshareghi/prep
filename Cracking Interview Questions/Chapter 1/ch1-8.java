/*
Cracking Interview - Chapter 1.8
Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
*/

class Main
{
	public static void main(String[] args) 
	{
		String first = "waterbottle";
		String second= "erbottlewat";		

		System.out.println(isSubstring(first,second));
	}	

	public static boolean isSubstring(String first, String second)
	{

		//since it's we wanna find if it's rotation, the two string should be equal in length
		if(first.length()!=second.length())
			return false;

		String combo = first + first;

		for(int i = 0; i<combo.length(); i++)
		{
			for(int j=0; j<second.length(); j++)
			{	
				if(combo.charAt(i) != second.charAt(j))
					break;
				if((j+1) == second.length())
					return true;
				
				i++;
			}
		}
		return false;
	}
}