package CodeChef;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import codeing.LinerCombination;

public class LinearCombinations {
	public static void main(String[] args) throws Exception 
	{
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		LinearCombinations lc = new LinearCombinations();
		
		//this is number of test cases
		int n=Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		int a[]=new int[n];
		int arr[]= new int[239];
		int vals[][]=new int[n][239];
		for (int i = 0; i < n; i++) 
		{
			a[i]=Integer.parseInt(st.nextToken());
			for (int j = 0; j < 239; j++) {
				vals[i][j]=a[i]*j;
			}
		}
		System.out.println(lc.getLinearCombos(vals, 0, 0, 0) %998244353);

	}
	private long getLinearCombos(int arr[][],int i,int jP,int currSum)
	{//here cursum is the sum upto this level of recursion
	//here we are storing in arr the scaled 0-238 values according to the input	
		// i is the level pointer of depth of recursion and also the number of scalars
		
		if (i==arr.length-1)
		{	int count=0;
			//if were at last element then we check if current sum+ given element is equal to 239 multiple
			//if it is then we increment count and return it
			
			for (int j = jP; j < 239; j++) {
				if ((currSum+arr[i][j])%239==0)
					count+=1;
			}
			System.out.println("running");
			return count;
			
		}
		else
		{long rowSum=0;
			for (int j = jP; j < 239; j++) {
				rowSum+=this.getLinearCombos(arr, i+1, jP+1, currSum+arr[i][j]);
			}
		return rowSum;
		}
	}
//write stuff down
}
