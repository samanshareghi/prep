class Main
{
	public static void main(String [] args)
	{
		char[] myArr  = "abababababbabababababababbbababbabbbabbaaaabbbbbabab".toCharArray();
		myArr = removeDups(myArr);
		System.out.println(String.valueOf(myArr));
	}

	public static char[] removeDups(char[] arr)
	{
		int jump, newLen;
		newLen = arr.length;

		for(int i=0; i<newLen; i++)
		{
			System.out.println(arr[i]);
			jump = 0;
			for(int j=i+1; j<newLen;j++)
			{
				if(arr[i] == arr[j])
				{
					jump++;
				}
				else
				{
					arr[j-jump] = arr[j];
				}
			}
			newLen -= jump;
		}

		char[] retVal = new char[newLen];

		for(int i=0; i<newLen;i++)
			retVal[i] = arr[i];

		return retVal;
	}
}