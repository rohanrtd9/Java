package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prog2b {
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
					int diff=x>y?x-y:y-x;
					int step=k*2;
					if(diff%step==0)
						System.out.println("Yes");
					else
						System.out.println("No");
				}
	}
}
