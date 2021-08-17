package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class program3 {
	public static void main(String[] args) throws Exception{
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					String s=br.readLine();
					int n=s.length();
					if((n&1)==1)
					{
						System.out.println(-1);
						continue;
					}
					char c[]=s.toCharArray();
					int oneSum=0;
					for (int i = 0; i < c.length; i++) {
						if(c[i]=='1')
							oneSum++;
					}
					if(oneSum==n||oneSum==0)
						System.out.println(-1);
					else if (oneSum==n/2) {
						System.out.println(0);
					}
					else if(oneSum>n/2)
					{
						System.out.println(oneSum-n/2);
					}
					else
					{
						System.out.println(n/2-oneSum);
					}
					
						
				}
	}

}
