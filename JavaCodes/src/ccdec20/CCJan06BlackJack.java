package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CCJan06BlackJack {
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
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					
					int nums[]=new int [n];
					
					st= new StringTokenizer(br.readLine());
					
					
					for (int i = 0; i < n; i++) {
						nums[i]=Integer.parseInt(st.nextToken());
					}
					//this array contains location of n as they come
					int sumN[]=new int [y+1];
					int sum=0;
					for (int ix : nums) {
							sum+=ix;
							if(sum>=sumN.length)
								break;
							sumN[sum]=1;
					}
					if(sum<x)
					{
						System.out.println(-1);
						continue;
					}
					sumN[0]=1;
					int sumN1[]=new int [y+1];
					
					int done=-1;
					//(n*(n-1))/2
					for (int swaps = 0; swaps <=2 ; swaps++) 
					{
						if(checkDone(sumN,x,y))
						{
							done=swaps;
							break;
						}
						sumN1=new int [y+1];
						for (int i = 0; i < sumN.length; i++) {
							if(sumN[i]==0)
								continue;
							for (int iz : nums) {
								if(i+iz>=sumN1.length)
									continue;
								sumN1[i+iz]=1;
							}
						}
						sumN=sumN1;
					}
					System.out.println(done);
				}
	}
	static boolean checkDone(int arr[], int l,int u)
	{
		//this function checks whether the bits form l to u inclusive
		//have 1 set
		for (int i = l; i <=u; i++) {
			if(arr[i]==1)
				return true;
		}
		return false;
	}
}
