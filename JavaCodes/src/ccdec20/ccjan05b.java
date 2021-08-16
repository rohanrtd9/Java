package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ccjan05b {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(System.out);
				StringTokenizer st= new StringTokenizer(br.readLine());
				ccjan05b cc= new ccjan05b();
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					int k=Integer.parseInt(st.nextToken());
					int arr[]= new int[n];
					st= new StringTokenizer(br.readLine());
					Map <String,Integer> mp = new HashMap<>();
					for (int i = 0; i < arr.length; i++) 
					{
						arr[i]=Integer.parseInt(st.nextToken());
					}
					Arrays.sort(arr);
					System.out.println(cc.getHeight(k, arr, 0, 0, n-1,mp));
				}
	}
	private int getHeight(int k,int arr[],int s1,int s2,int p,Map <String,Integer> mp)
	{
		int max=Math.max(s1, s2);
		int min=Math.min(s1, s2);
		String Key=max+","+min;
		//String Key=p+","+max+","+min;
		if((s1>=k) && (s2>=k))
		{
		//mp.put(Key, 0);
		return 0;
		}
		if (p<0)
			return -1;
		
		if(mp.containsKey(Key))
			return mp.get(Key);
		
		
		
		else if (s1>=k)
		{
			int res=this.getHeight(k, arr, s1, s2+arr[p], (p-1),mp);
			if (res==-1)
			{
				mp.put(Key, -1);
				return -1;
			}
			mp.put(Key, ++res);	
			return res;
		}
			
		else if (s2>=k)
		{
			int res=this.getHeight(k, arr, s1+arr[p], s2, (p-1),mp);
			if (res==-1)
			{
				mp.put(Key, -1);
				return -1;
			}
			mp.put(Key, ++res);	
			return res;
		}
			
		int r1=this.getHeight(k, arr, s1, s2+arr[p], (p-1),mp);
		int r2=this.getHeight(k, arr, s1+arr[p], s2, (p-1),mp);
		if(r1==-1)
		{
			if (r2==-1)
			{
				mp.put(Key, -1);
				return -1;
			}
			mp.put(Key, ++r2);	
			return r2;
		}
		if(r2==-1)
		{
			mp.put(Key, ++r1);	
			return r1;
		}
		int res=1+Math.min(r1, r2);
		mp.put(Key, res);
		return res;
	}
}
