package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ccjan04 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(System.out);
				StringTokenizer st= new StringTokenizer(br.readLine());
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				//String directions[]={"RU","LU","LD","RD"}; 0 1 2 3
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					int d=0;
					//this is number of test cases
					int n=Integer.parseInt(st.nextToken());
					int k=Integer.parseInt(st.nextToken());
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					int endX=0,endY=0;
					int l=k;
					while(k-->0)
					{
						//ru direction
						if (((d)&3) ==0)
						{
							if (x>y)
							{
								
								x=n;
								y=n-(x-y);
								d=1;
							}
							else if (y>x)
							{
								y=n;
								x=n-(y-x);
								d=3;
							}
							else
							{
								endX=x;
								endY=y;
								break;
							}
							
						}
						//lu direction
						else if (((d)&3) ==1)
						{
							if (y+x>n)
							{
								
								y=n;
								x=(x-y);
								d=2;
							}
							else if (y+x<n)
							{
								y=x;
								x=0;
								d=0;
							}
							else
							{
								endX=0;
								endY=n;
								break;
							}
						}
						//ld
						else if (((d)&3) ==2)
						{
							if (x>y)
							{
								
								x=x-y;
								y=0;
								d=1;
							}
							else if (y>x)
							{
								y=y-x;
								x=0;
								d=3;
							}
							else
							{
								endX=0;
								endY=0;
								break;
							}
						}
						//rd
						else
						{}
						
						
						if ((x==n && y==n) || (x==n && y==0)||(x==0 && y==0) || (x==0 && y==n))
						{
							endX=x;
							endY=y;
							break;
						}
					}
					
					
				}
	}

}
