package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class codedrive2 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		codedrive2 cc= new codedrive2();
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());

		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			int a[]= new int[n];
			
			out.println(2*cc.returnSum(a, 0));
		}
		out.flush();
	}
	
	private int returnSum(int a[],int ptr)
	{
		int sum=0;
		if(ptr==a.length-1)
		{
			
			for (int i = 0; i < 3; i++) {
				a[ptr]=i;
				sum+=this.getExtremes(a);
			}
			return sum;
		}
		for (int i = 0; i < 3; i++) {
			a[ptr]=i;
			sum+=this.returnSum(a, ptr+1);
		}
		return sum;
	}
	private int getExtremes(int a[])
	{
		//it checks if array has extremes
		int count=0;
		for (int i = 1; i < a.length-1; i++) 
			if(a[i]>a[i-1] && a[i]>a[i+1])
				count++;
		return count;
	}
}
