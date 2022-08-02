package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StarterPracticeRemoveAdd {

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
			//this is n
			int n=Integer.parseInt(st.nextToken());
			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			Map<Integer,Integer> mp=new HashMap<>();
			//in this loop we put the count of elements
			int l=0;
			int r=n-1;
			int minCost=n-1;
			int currentcost;
			for (int i = 0; i < s.length; i++) 
			{
				a[i]=Integer.parseInt(s[i]);
				if(mp.containsKey(a[i]))
				{
					//then we traverse left to point where other a[i] isnt there
					while(a[l]!=a[i])
					{
						mp.remove(a[l]);
						l++;
					}
					l++;
				}
				else
				{
					mp.put(a[i], 1);
				}
				currentcost= (int)Math.min(2*l+ n-i-1, 2*(n-i-1)+l );
				if(minCost>currentcost)
					minCost=currentcost;
			}
			
			out.println(minCost);
		}
		out.flush();
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}
