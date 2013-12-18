import java.util.*;

class Main
{
	public static void main( String [] args)
	{
		String victim = "a";
		
		System.out.println(buff(victim));
		System.out.println(noBuff(victim));
	}

	public static boolean buff(String victim)
	{
		boolean[] myArr = new boolean[256];
		Arrays.fill(myArr, false);

		for(int i=0; i<victim.length(); i++)
			if(myArr[victim.charAt(i)])
				return false;
			else
				myArr[victim.charAt(i)] = true;

		return true;
	}

	public static boolean noBuff(String victim)
	{
		for(int i=0; i<victim.length(); i++)
			for(int j=i+1; j<victim.length(); j++)
				if(victim.charAt(i) == victim.charAt(j))
					return false;

		return true;
	}
}