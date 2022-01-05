package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Infinity_Arr_Sum_Square {
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
			
			//initialize array with all 1s
			int arr[]=new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=1;
			}
		}
		out.flush();
	}
}
