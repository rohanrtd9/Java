package cses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArrayDescription {public static void main(String[] args)throws Exception 
{	
	//importing io functions
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st= new StringTokenizer(br.readLine());
	//this is number of test cases
	int n=Integer.parseInt(st.nextToken());
	int m=Integer.parseInt(st.nextToken());
	int x[]=new int[n];
	
	st= new StringTokenizer(br.readLine());
	
	for (int i = 0; i < x.length; i++) {
		x[i]=Integer.parseInt(st.nextToken());
	}
	
	out.println();
	
	out.flush();
}
}



