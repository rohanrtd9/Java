package cses;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CountingRooms {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int count=0;
		char g[][]=new char[m][n];
		for (int i = 0; i < m; i++) {
			g[i]=br.readLine().toCharArray();
		}
		LinkedList <String> nodes=new LinkedList<>();
		int visited[][]=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j]=='.' && visited[i][j]==0)
				{
					count++;
					nodes.add(i+" "+j);
					fill(nodes,visited,g);
				}
					
			}
		}
		out.println(count);
		out.flush();
	}
	static void fill (LinkedList <String> nodes,int visited[][],char g[][])
	{
		while(nodes.size()>0)
		{
			String s[]=nodes.pop().split(" ");
			int m=Integer.parseInt(s[0]);
			int n=Integer.parseInt(s[1]);
			
			visited[m][n]=1;
			if(m>0)
				if(visited[m-1][n]==0 && g[m-1][n]=='.')
					nodes.add((m-1)+" "+n);
				
			if(n>0)
				if(visited[m][n-1]==0 && g[m][n-1]=='.')
					nodes.add((m)+" "+(n-1));
			if(m<g.length-1)
				if(visited[m+1][n]==0 && g[m+1][n]=='.')
					nodes.add((m+1)+" "+n);
				
			if(n<g[0].length-1)
				if(visited[m][n+1]==0 && g[m][n+1]=='.')
					nodes.add((m)+" "+(n+1));
			
		}
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}
