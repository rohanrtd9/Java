package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class CCJan06BlackJack04 {
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
			//n given in input
			int n=Integer.parseInt(st.nextToken());
			//x given in input
			int x=Integer.parseInt(st.nextToken());
			//y given in input
			int y=Integer.parseInt(st.nextToken());

			st= new StringTokenizer(br.readLine());
			//this array contains info of cards that chef has
			int a[]=new int[n];
			for (int i = 0; i < a.length; i++) 
			{
				a[i]=Integer.parseInt(st.nextToken());
			}
			int reachableSum[]=new int[y+1];
			ArrayList<Integer> states[]=new ArrayList[y+1];
			reachableSum[0]=1;
			states[0]=new ArrayList<>();
			for (int i = 0; i < a.length; i++) {
				for (int j = reachableSum.length-1; j >=a[i] ; j--) 
				{
					reachableSum[j]|=reachableSum[j-a[i]];
					if(states[j-a[i]]!=null)
					{
						if(states[j]==null)
						states[j]=new ArrayList<>();
						states[j].addAll(states[j-a[i]]);
						states[j].add(a[i]);
					}
					else
					{}
				}
			}
			int count=-1;
			for (int i=x;i<=y;i++)
			{
				if(states[i]==null)
					continue;
				int c=states[i].size();
				int tcx=0;
				for (int j = 0; j < a.length && c>0; j++) {
					if(states[i].contains(a[j]))
						c--;
					else
						tcx++;
				}
				if(count==-1)
					count=tcx;
				else
				{
					count=Math.min(count, tcx);
				}
			}
			out.println(count);
		}out.flush();
	}
	
}
