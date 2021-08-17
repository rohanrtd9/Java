package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class program2 {
	public static void main(String[] args) throws Exception
	{
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					
					//this is number of test cases
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					int k=Integer.parseInt(st.nextToken());
					int n=Integer.parseInt(st.nextToken());
					boolean run=true;
					int jump=0;
					while(true)
					{
						if(x<y)
						{
							x+=k;
							if(y+k>n)
							{
								y-=k;
								
								
							}
							else
								y+=k;
							if	(y<x)
								jump++;
						}
							
						else
						{
							x-=k;
							if(y-k<0)
							{
								y+=k;
								
							}
							else 
								y-=k;
							if	(y>x)
								jump++;
							
						}
						if(y==x)
						{
							System.out.println("Yes");
							break;
						}
						if (jump>=2)
						{
							System.out.println("No");
							break;
						}
					}
				}
	}

}
