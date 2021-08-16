package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Euler21AmicableNumbers 
{
	public static void main(String[] args) throws Exception
	{
		int arr[]= new int[100000+1];
		for (int i = 1; i < 100000; i++) {
			arr[i]=1;
		}
		for (int i = 2; i*i<=100000; i++) {
			arr[i*i]+=i;
			for (int j = i+1; i*j<=100000 ; j++) {
				arr[i*j]+=j;
				arr[i*j]+=i;
			}
		}
		ArrayList<Integer> amiNo=new ArrayList<Integer>();
		for (int i = 0; i < 100000; i++) {
			if (arr[i]==i)
				continue;
			if (arr[i]>100000)
				continue;
			if (arr[arr[i]]==i)
				{
					amiNo.add(i);
				}
		}
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
				
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
				
		//loop for doing coding 
		while(tc-->0)
		{	st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int sum=0;
			for (Integer inte : amiNo) 
			{
				if (inte<=n)
					{
					sum+=inte;
					}
			}
			System.out.println(sum);
		}
	}

}
