/*
Cracking interview chapter 1.6
Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
*/

class Main
{
	public static void main(String[] args) {
		int[][] firstArr= {
			{1,3,8,2,0},
			{4,5,2,1,9},
			{3,2,9,3,4},
			{7,8,2,1,6},
			{4,1,6,7,5}
		};

		int[][] secondArr = {
			{1,3,8,2,0,8},
			{4,5,2,1,9,9},
			{3,2,9,3,4,3},
			{7,8,2,1,6,4},
			{4,1,6,7,5,7},
			{9,0,5,3,1,2}
		};

		int[][] myArr = secondArr;

		rotate(myArr);

		for(int i=0; i<myArr.length; i++)
		{
			for(int j=0; j<myArr.length; j++)
				System.out.print(myArr[i][j] + "\t");
			System.out.println();
		}
	}

	public static void rotate(int[][] myArr)
	{
		int till = myArr.length;
		int tl, tr, br, bl;

		for( int level = 0; level<myArr.length/2; level++)
		{
			till--;
			for(int i = level; i<till; i++)
			{
				tl = myArr[level][i]; // going through top row
				tr = myArr[i][till]; // going through right column
				br = myArr[till][till+level-i]; // going through bottom row
				bl = myArr[till+level-i][level]; // going through left column

				//Swap
				myArr[level][i] = bl;
				myArr[i][till] = tl;
				myArr[till][till+level-i] = tr;
				myArr[till+level - i][level] = br;
			}
		}
	}
}

























