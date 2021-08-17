package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CCjan08 {
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
					//this is number of test cases
					int n=Integer.parseInt(st.nextToken());
					int m=Integer.parseInt(st.nextToken());
					ArrayList<Integer> newAdded= new ArrayList<>();
					int a[]=new int[n];
					int max=-1;
					st= new StringTokenizer(br.readLine());
					for (int i = 0; i < a.length; i++) {
						
						a[i]=Integer.parseInt(st.nextToken());
						max=max|a[i];
						newAdded.add(a[i]);
					}
					
					int b[]= new int[m];
					st= new StringTokenizer(br.readLine());
					for (int i = 0; i < b.length; i++) {
						b[i]=Integer.parseInt(st.nextToken());
						
					} 
					
					Set<Integer>set= new HashSet<>();
					
					set.add(0);
					while(! newAdded.isEmpty())
					{
						int p=newAdded.remove(0);
						set.add(p);
						for (int j = 0; j < a.length; j++) {
							int res=a[j]|p;
							if (!set.contains(res))
								{	
									set.add(res);
									newAdded.add(res);
								}
							
						}
						for (int j = 0; j < b.length; j++) {
							int res=b[j]&p;
							if (!set.contains(res))
							{	
								set.add(res);
								newAdded.add(res);
							}
							
						}
					}
					
					out.println(set.size());
				}
				out.flush();
	}

}
