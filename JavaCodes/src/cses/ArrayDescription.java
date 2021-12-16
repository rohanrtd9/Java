package cses;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArrayDescription {public static void main(String[] args)throws Exception 
{	
	//importing io functions
	int mod=1000000007;
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st= new StringTokenizer(br.readLine());
	//this is number of test cases
	int n=Integer.parseInt(st.nextToken());
	
	//m is the maximum allowed value
	int m=Integer.parseInt(st.nextToken());
	int x[]=new int[n];
	
	st= new StringTokenizer(br.readLine());
	
	for (int i = 0; i < n; i++) {
		x[i]=Integer.parseInt(st.nextToken());
	}
	
	int dp[][]=new int[m+2][n];
	//of our array has first value as zero 
	//ie the number can be anything then we have to traverse the array to find out
	//the next value that can be present and adjust our range accordingly
	for (int i = 0; i < n; i++) {
		if(x[i]==0)
		{
			for (int j = 1; j <=m; j++) {
				dp[j][i]=1;
			}
		}
		else
			//one value is possible
			dp[x[i]][i]=1;
		
	}
	long ans=0;
	if(n==1)
	{
		for (int i = 0; i < m+2; i++) {
			ans+=dp[i][0];
		}
	}
	else
	{
		for (int i = 1; i <n-1; i++) {
			for (int j = 1; j <=m ; j++) {
				if(dp[j][i]==1)
					dp[j][i]=((dp[j][i-1]+dp[j-1][i-1])%mod+dp[j+1][i-1] )%mod;
			}
		}
		for (int j = 1; j <=m ; j++) {
			if(dp[j][n-1]==1)
				ans+=((dp[j][n-1-1]+dp[j-1][n-1-1])%mod+dp[j+1][n-1-1] )%mod;
		}
	}
		
	out.println((ans)%mod);
	
	out.flush();
}
}



