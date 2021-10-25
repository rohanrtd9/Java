package cses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GridPaths {public static void main(String[] args)throws Exception 
{	
	//importing io functions
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st= new StringTokenizer(br.readLine());
	//this is number of test cases
	int n=Integer.parseInt(st.nextToken());
	char grid[][]=new char[n][n];
	String s;
	for (int i = 0; i < n; i++) {
		s=br.readLine();
		grid[i]=s.toCharArray();
	}
	

	//this is the grid that we have in matrix form 
	int gridPath[][]=new int[n][n];
	int mod=1000000007;
	
	if (grid[n-1][n-1]=='.')
		gridPath[n-1][n-1]=1;
	for (int i = n-2; i >=0 ; i--) 
	{
		if (grid[n-1][i]=='.')
			gridPath[n-1][i]=gridPath[n-1][i+1];
		if (grid[i][n-1]=='.')
			gridPath[i][n-1]=gridPath[i+1][n-1];
	}
	
	// we should actually just calculate the grid path
	//the iterate and if we find * then we skip that section
	for (int i = n-2; i >= 0; i--) 
	{
		for (int j = n-2; j >= 0; j--) 
		{
			if (grid[i][j]=='.')
				gridPath[i][j]=(gridPath[i+1][j]+gridPath[i][j+1])%mod;
		}
	}
	out.println(gridPath[0][0]);
	out.flush();
}
}



