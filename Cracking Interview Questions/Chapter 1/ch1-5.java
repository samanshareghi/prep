/*
Cracking interview Chapter 1.5
Write a method to replace all spaces in a string with ‘%20’
*/
class Main
{
	public static void main(String[] args) 
	{
		char[] victim = "saman is a kewl person".toCharArray();

		victim = replaceSpace(victim);

		System.out.println(String.valueOf(victim));	
	}

	public static char[] replaceSpace(char[] victim)
	{
		
		int numSpace = 0;

		for(char c : victim)
			if(c == ' ')
				numSpace++;

		numSpace *= 3;

		char[] retVal = new char[victim.length + numSpace];

		int j=0;
		for(int i=0; i<victim.length; i++)
		{
			j++;

			if(victim[i] == ' ')
			{
				retVal[j++]='%';
				retVal[j++]='2';
				retVal[j]='0';
			}
			else
				retVal[j] = victim[i];
		}

		return retVal;
	}
}