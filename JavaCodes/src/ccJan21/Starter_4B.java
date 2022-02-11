package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter_4B {
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
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			char[] s1=br.readLine().toCharArray();
			char[] s2=br.readLine().toCharArray();
			
			
			//contains zeroes in suffix including the index
			int zc1[]=new int[n+1];
			int zc2[]=new int[n+1];
			
			for (int i = n-1; i >=0 ; i--) {
				
				zc1[i]=zc1[i+1];
				zc2[i]=zc2[i+1];
				if(s1[i]=='0')
				{
					zc1[i]++;
				}
				if(s2[i]=='0')
				{
					zc2[i]++;
				}
			}
			
			
			
			int dp[][]=new int[n+1][n+1];
			dp[n][n]=0;
			
			//initializing the paths
			int ptr=n;
			while(--ptr>=0)
			{
				if (s1[ptr]=='1')
					dp[n][ptr]=zc1[ptr];
				if(s2[ptr]=='1')
					dp[ptr][n]=zc2[ptr];
			}
			/**
			for (int i = n-1; i >=0; i--) {
				for (int j = n-1; j >=0; j--) {
					
					if(s1[i]=='1')
					{
						dp[i][j]=zc1[i]+zc2[j];
					}
					if(s2[j]=='1')
					{
						dp[i][j]=zc1[i]+zc2[j];
					}
					
				}
			}
			**/
			for (int i = n-1; i >=0; i-- ) {
				dp[i][n]+=dp[i+1][n];
				dp[n][i]+=dp[n][i+1];
			}
			//here we look for the elements
			for (int i = n-1; i >=0; i--) 
			{
				for (int j = n-1; j >=0; j--) 
				{
					int t1=dp[i+1][j];
					int t2=dp[i][j+1];
					if (s1[i]=='1')
					{
						
					}
				}
			}
			out.println(dp[0][0]);
		}
		out.flush();
	}
}
