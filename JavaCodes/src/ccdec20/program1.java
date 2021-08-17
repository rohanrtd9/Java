package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class program1 {
	public static void main(String[] args)throws Exception
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
					int n=Integer.parseInt(st.nextToken());
					String s=br.readLine();
					char c[]=s.toCharArray();
					int presentCount=0;
					for (int i = 0; i < c.length; i++) {
						if (c[i]=='1')
						{
							presentCount++;
						}
					}
					int dayRem=120-n;
					if(dayRem+presentCount>=90)
						System.out.println("YES");
					else
						System.out.println("NO");
				}
	}

}
