package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Euler29 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int n=Integer.parseInt(st.nextToken());
		
		
		
		
		//now we iterate over primeIndicator
		//if we encounter prime then it'll have full monty
		//but as we go to its square etc
		//we'll take toll
		//let's save toll in separate array
		//where we save max value of toll
		int toll[]=new int[n+1];
		
		for (int i = 2; i < toll.length; i++) {
			
			for (int j = 2; Math.pow(i, j)< toll.length; j++) {
				int idx=(int) Math.pow(i, j);
				int tol=(n-j)/j;
				
				if (tol>toll[idx])
					toll[idx]=tol;
			}
			
		}
		int tot=(n-1)*(n-1);
		//next we deduct toll from max possibility
		for (int i = 0; i < toll.length; i++) {
			tot-=toll[i];
		}
		
		out.println(tot);
		
		//loop for doing coding 
		
		out.flush();
	}
	
}
