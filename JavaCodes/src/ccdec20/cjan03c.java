package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class cjan03c {
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
					int m=Integer.parseInt(st.nextToken());
					int n=Integer.parseInt(st.nextToken());
					
					int a[]= new int[m];
					st= new StringTokenizer(br.readLine());
					long asum=0,bsum=0;
					for (int i = 0; i < a.length; i++) {
						a[i]=Integer.parseInt(st.nextToken());
						asum+=a[i];
					}
					Arrays.sort(a);
					int b[]= new int[n];
					st= new StringTokenizer(br.readLine());
					for (int i = 0; i < b.length; i++) {
						b[i]=Integer.parseInt(st.nextToken());
						bsum+=b[i];
					}
					Arrays.sort(b);
					int aPtr=-1;
					int bPtr=b.length;
					int count=0;
					while(++aPtr<a.length && --bPtr>=0 && asum<=bsum)
					{
						
						int bb=b[bPtr];
						int aa=a[aPtr];
						if(bb<=aa)
						{
							break;
						}
						count++;
						asum+=(bb-aa);
						bsum-=(bb-aa);
					}
					if(asum<bsum)
						System.out.println(-1);
					else System.out.println(count);
				}
	}
	

}
