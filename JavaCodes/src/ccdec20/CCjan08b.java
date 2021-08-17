package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CCjan08b {
	public static void main(String[] args) throws Exception
	{
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
			int m=Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			ArrayList<Integer> a = new ArrayList<>();
			while(n-->0)
			{
				a.add(Integer.parseInt(st.nextToken()));
			}
			ArrayList<Integer> b = new ArrayList<>();
			while(m-->0)
			{
				b.add(Integer.parseInt(st.nextToken()));
			}
			ArrayList<Integer>nodes= new ArrayList<>();
			Set<Integer> nodesVisited= new HashSet<>();
			nodes.add(0);
			nodes.addAll(a);
			while(!nodes.isEmpty())
			{
				int p=nodes.remove(0);
				if (nodesVisited.contains(p))
					continue;
				nodesVisited.add(p);
				int ptr=1;
				while(ptr<p)
				{
					int res=p|ptr;
					if(nodesVisited.contains(res))
					{
						ptr=ptr<<1;
						continue;
					}
					boolean isPossible=false;
					for (Integer orVal : a) {
						if ((p|orVal)==res)
						{
							isPossible=true;
							break;
						}
					}
					if(isPossible)
					{
						if(!nodes.contains(res))
							nodes.add(res);
					}
					ptr=ptr<<1;
					
				}
			}
			
		}
	}
}
