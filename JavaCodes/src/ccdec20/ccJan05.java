package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccJan05 {
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
					int k=Integer.parseInt(st.nextToken());
					int arr[]= new int[n];
					st= new StringTokenizer(br.readLine());
					for (int i = 0; i < arr.length; i++) 
					{
						arr[i]=Integer.parseInt(st.nextToken());
					}
					int s1=0,s2=0;
					int c=0;
					Arrays.sort(arr);
					int i = arr.length-1;
					while( i >=0 && s1<k && s2<k ) 
					{
						if ((i&1)==0)
						{
							s1+=arr[i--];
							c++;
						}
						else
						{
							s2+=arr[i--];
							c++;
							
						}
					}
					if (s1>k)
					{
						while(i >=0 && s2<k) 
						{
							s2+=arr[i--];
							c++;
							
						}
					}
					else
					{
						while(i >=0 && s1<k) 
						{
							s1+=arr[i--];
							c++;
							
						}
					}
					if (s1>n && s2>n)
					{
						System.out.println(	c);
					}
					else
						System.out.println(-1);
				}
	}
}
