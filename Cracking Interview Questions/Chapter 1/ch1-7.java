/*
Cracking Interview - Chapter 1.7
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column is set to 0.
*/

import java.util.*;
class Main
{
	public static void main(String[] args) {
		int[][] firstArr= {
			{1,3,8,2,0},
			{4,5,2,1,9},
			{3,2,9,3,4},
			{7,8,2,1,6},
			{4,1,6,7,5},
			{9,0,5,3,1}

		};
		
		int[][] secondArr = {
			{1,3,8,2,0,8},
			{4,5,2,1,9,9},
			{3,2,9,3,4,3},
			{7,8,2,1,6,4},
			{4,1,6,7,5,7},
			{9,0,5,3,1,2}
		};

		int[][] thirdArr= {
			{0,3,8,2,0},
			{4,5,2,1,9},
			{3,2,0,3,4},
			{7,8,2,1,6},
			{4,1,6,7,5},
			{0,3,5,3,0}

		};

		int[][] fourthArr= {
			{1},
			{4},
			{3},
			{7},
			{4},
			{0}

		};

		int[][] fifthArr= {
			{1,3},
			{4,1},
			{3,5},
			{7,9},
			{4,0},
			{1,2}

		};

		int[][] myArr = fourthArr;
		System.out.println("Before zero out");
		for(int i=0; i<myArr.length; i++)
		{
			for(int j=0; j<myArr[0].length; j++)
				System.out.print(myArr[i][j] + "\t");
			System.out.println();
		}


		zeroOut(myArr);
		System.out.println();

		System.out.println("After zero out");
		for(int i=0; i<myArr.length; i++)
		{
			for(int j=0; j<myArr[0].length; j++)
				System.out.print(myArr[i][j] + "\t");
			System.out.println();
		}
	}

	public static void zeroOut(int[][] myArr)
	{
		int rLen = myArr.length;
		int cLen = myArr[0].length;

		int[] zeroRows = new int[rLen];
		int[] zeroCols = new int[cLen];
		
		for(int i=0; i<rLen; i++)
		{
			for(int j=0; j<cLen; j++)
				if(myArr[i][j] == 0)
				{
					zeroRows[i] = 1;
					zeroCols[j] = 1;
				}
		}

		for(int i=0; i<rLen; i++)
			for(int j=0; j<cLen; j++)
				if(zeroRows[i]==1 ||zeroCols[j]==1)
					myArr[i][j] = 0;
	}
}