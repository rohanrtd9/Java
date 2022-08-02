package GoogleKickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ks3 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int cnt=0;
		//loop for doing coding 
		while(cnt++<tc)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			int n=Integer.parseInt(st.nextToken());
			
			//this is dp sorta array to store info of elements as they come, since we need to be at h index i to be at h index i+=1
			//therefore it is optimized way to store this information
			
			String s[]=br.readLine().split(" ");
			int dp[]=new int[100002];
			int hIdx=0,currentPool=0;
			out.print("Case #"+cnt+":");
			for (int i = 0; i < s.length; i++) 
			{
				
				
				int numC=Integer.parseInt(s[i]);
				
				//if the number is greater than the current hIdx
				if(numC>hIdx)
				{currentPool+=1;
				dp[numC+1]-=1;
				}
			if (currentPool>hIdx)
			{
				hIdx+=1;
				currentPool+=dp[hIdx+1];
			}
			out.print(" "+hIdx);
			}
			
			out.print
			("\n");
		}
		out.flush();
	}
}
