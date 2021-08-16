package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CCJAN08c {
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
			int a[]= new int[n];
			
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < a.length; i++) 
			{
				a[i]=Integer.parseInt(st.nextToken());
			}
			int b[]= new int[m];
			
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < b.length; i++) 
			{
				b[i]=Integer.parseInt(st.nextToken());
			}
			Set<Integer> s=new HashSet<>();
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					s.add(a[i]&b[j]);
				}
			}
			ArrayList<Integer> dvs=new ArrayList<>();
			dvs.addAll(s);
			for (int i = 0; i < a.length; i++) {
				for (Integer vals : dvs) {
					s.add(a[i]|vals);
				}
			}
			out.println(s.size());
		}
		out.flush();
	}

}
