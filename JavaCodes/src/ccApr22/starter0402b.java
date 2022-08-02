package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class starter0402b {
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
			HashMap<Integer,Integer> mp = new HashMap<>();
			for (int i = 0; i < s.length; i++) 
				a[i]=Integer.parseInt(s[i]);
			st= new StringTokenizer(br.readLine());
			//this is n
			int x=Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < s.length; i++) {
				int res=a[i];
				res=(res&x);
				if (res==0)
					continue;
				if(mp.containsKey(res))
					mp.put(res,mp.get(res)+1);
				else 
					mp.put(res, 1);
			}
			long pos=n*(n-1);
			pos/=2;
			for (Integer keys : mp.keySet()) {
				int num=mp.get(keys);
				num=num*(num-1);
				pos-=num;
			}
			out.println(pos);
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