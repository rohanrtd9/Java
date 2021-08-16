package ccdec20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.StringTokenizer;



public class MAxIslands {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(System.out);
				StringTokenizer st= new StringTokenizer(br.readLine());
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					int m=Integer.parseInt(st.nextToken());
					
					int arr[][]=new int[n][m];
					for (int i = 0; i < n; i++) {
						char c[]=br.readLine().toCharArray();
						for (int j = 0; j < c.length; j++) {
							if(c[j]=='.')
								arr[i][j]=0;
							else
								arr[i][j]=1;
						}
					}
					
				}
	}
	private int getCount(int arr[][],int i,int j)
	{
		return 0;
	}
	private int getIslandCount(int arr[][])
	{
		int cr[][]=arr.clone();
		int count=0;
		for (int i = 0; i < cr.length; i++) {
			
		}
		return count;
	}
}