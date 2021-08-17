package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Euler18MaxPathSum 
{
	public static void main(String[] args)throws Exception
	{
		//importing io functions
		Euler18MaxPathSum ee= new Euler18MaxPathSum();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			final int a[][]= new int [n][n+1];
			for (int i = 0; i < a.length; i++) 
			{
				st= new StringTokenizer(br.readLine());
				for (int j = 0; j <=i; j++) 
				{
					a[i][j]=Integer.parseInt(st.nextToken());
				}
				
			}
			System.out.println(ee.getMax(a, 0, 0));
		}		
	}
	
	private int getMax(int a[][],int cPtr,final int rPtr)
	{
		if (a.length==1)
			return a[0][0];
		else if (cPtr==a.length-2)
			return a[cPtr][rPtr]+Math.max(a[cPtr+1][rPtr], a[cPtr+1][rPtr+1]);
		return  a[cPtr][rPtr]+Math.max(this.getMax(a, (cPtr+1), rPtr ), this.getMax(a, cPtr+1, rPtr+1));
	}
}
