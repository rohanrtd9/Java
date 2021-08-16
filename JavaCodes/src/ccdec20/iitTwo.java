package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class iitTwo {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				int pow2[]= {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432};
				iitTwo it2= new iitTwo();
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					Map<Integer,String> mp = new HashMap<>();
					st= new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					int k=Integer.parseInt(st.nextToken());
					String s=it2.canSum(n, k, pow2, mp, "");
					if (s==null)
						System.out.println(-1);
					else System.out.println(s);
					
					
				}
	}
	private String canSum(int n,int k, int arr[],Map<Integer,String> mp,String cr)
	{
		if(mp.containsKey(k))
			return mp.get(k);
		if (k==0 && n==0)
		{
			mp.put(k, cr);
			return cr;
		}
		if (k<=0 ||n==0)
		{
			mp.put(k, null);
			return null;
		}
		
		else if(n>0)
		{
			for (int i = 0; i < arr.length && k-arr[i]>=0; i++) {
				String s=Character.toString((char)(97+i));
				String result=this.canSum(n-1, k-arr[i], arr, mp, cr+s);
				if (result!=null)
				{
					mp.put(k, result);
					return result;
				}
			}
		}
		return null;
	}
}
