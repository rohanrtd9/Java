package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CCJAN08F {
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
			//number of or stuff
			ArrayList<Integer> a=new ArrayList<>();
			int max=0;
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i <n; i++) {
				int nn=Integer.parseInt(st.nextToken());
				max=max|nn;
				a.add(nn);
			}
			//number of and stuff
			ArrayList<Integer> b=new ArrayList<>();
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i <m; i++) {
				b.add(Integer.parseInt(st.nextToken()));
			}
			int size=Integer.numberOfTrailingZeros(Integer.highestOneBit(max))+1;
			int arr[]=new int[(int) Math.pow(2,size)];
			arr[0]=1;
			for (int i : a) {
				arr[i]=1;
			}
			
			
			
			for (int i = 1; i < arr.length; i++) 
			{
				if (arr[i]==0)
					continue;
				for (int j = i+1;  j < arr.length; j++) 
				{
					if (arr[j]==0)
						continue;
					int res=i|j;
					if (res!=1)
						arr[res]=2;
				}	
			}
			for (int i = arr.length-1;i >0; i--) 
			{
				if (arr[i]==0)
					continue;
				for (int ii : b) {
					int res=i&ii;
					if (res!=1)
						arr[res]=2;
				}
			}
			for (int i = 1; i < arr.length; i++) 
			{
				if (arr[i]<2)
					continue;
				for (int j = i+1;  j < arr.length; j++) 
				{
					if (arr[j]==0)
						continue;
					arr[i|j]=1;
				}	
			}
			
			
			int count=0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i]>0)
				{out.print(i+" ");count++;}
					
			}out.println(" - "+count);
		}
		out.flush();
	}

}

